package com.demo.dev2.stocktrade.service.impl;

import com.demo.dev2.stocktrade.dto.TradeDto;
import com.demo.dev2.stocktrade.dto.TradeMinMaxDto;
import com.demo.dev2.stocktrade.exception.TradeDoesNotExistException;
import com.demo.dev2.stocktrade.exception.TradeExistException;
import com.demo.dev2.stocktrade.exception.TradeUnavailableException;
import com.demo.dev2.stocktrade.exception.UserDoesNotExistException;
import com.demo.dev2.stocktrade.mapper.Mapper;
import com.demo.dev2.stocktrade.model.Trade;
import com.demo.dev2.stocktrade.model.User;
import com.demo.dev2.stocktrade.repository.TradeRepository;
import com.demo.dev2.stocktrade.repository.UserRepository;
import com.demo.dev2.stocktrade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TradeDto createNewTrade(TradeDto tradeDto) {
        Optional<Trade> existTrade = tradeRepository.findById(tradeDto.getId());

        Optional<User> existUser = userRepository.findById(tradeDto.getUser().getId());
        if(!existUser.isPresent()){
            userRepository.save(Mapper.mapToUser(tradeDto.getUser()));
        }

        if(existTrade.isPresent()){
            // Throw an exception
            throw new TradeExistException("Trade already exists");
        }

        return Mapper.mapToTradeDto(tradeRepository.save(Mapper.mapToTrade(tradeDto)));
    }

    @Override
    public TradeDto findOneTrade(Long id) {
        Optional<Trade> existTrade = tradeRepository.findById(id);
        if(!existTrade.isPresent()){
            // Does not exist exception
            throw new TradeDoesNotExistException("Trade not found.");
        }
        return Mapper.mapToTradeDto(existTrade.get());
    }

    @Override
    public List<TradeDto> findTradeByUser(Long id) {
        Optional<User> existUser = userRepository.findById(id);
        if(!existUser.isPresent()){
            // User not found
            throw new UserDoesNotExistException("User does not exists");
        }

        User trader = existUser.get();
        List<Trade> trades = tradeRepository.findByUser(trader);
        return trades.stream().map(Mapper::mapToTradeDto).collect(Collectors.toList());
    }

    @Override
    public List<TradeDto> findByTradeBySymbolAndTypeInDateRange(String symbol, String type, LocalDate start, LocalDate end) {
        ZoneId zoneId = ZoneId.of("UTC-4");
        ZonedDateTime startOfDay = start.atStartOfDay(zoneId);
        ZonedDateTime endOfDay = end.plusDays(1).atStartOfDay(zoneId).minusNanos(1);

        long count = tradeRepository.countBySymbol(symbol);
        if(count == 0){
            throw new TradeUnavailableException("Trades Does Not Exists");
        }

        List<Trade> trades = tradeRepository.findBySymbolAndTypeAndTimestampBetween(symbol, type, startOfDay, endOfDay);
        return trades.stream().map(Mapper::mapToTradeDto).collect(Collectors.toList());
    }

    @Override
    public List<TradeDto> findAllTrades() {
        List<Trade> trades = tradeRepository.findAllByOrderByIdAsc();
        return trades.stream().map(Mapper::mapToTradeDto).collect(Collectors.toList());
    }

    @Override
    public TradeMinMaxDto findTradeMinMaxBySymbol(String symbol, LocalDate start, LocalDate end) {
        ZoneId zoneId = ZoneId.of("UTC-4");
        ZonedDateTime startOfDay = start.atStartOfDay(zoneId);
        ZonedDateTime endOfDay = end.plusDays(1).atStartOfDay(zoneId).minusNanos(1);

        long count = tradeRepository.countBySymbol(symbol);
        if(count == 0){
            throw new TradeUnavailableException("Trades Does Not Exists");
        }
        TradeMinMaxDto tradeMinMax = tradeRepository.findTradeMinMax(symbol, startOfDay, endOfDay);

        System.out.println("Hi "+tradeMinMax.getHighest());
        System.out.println("Hi "+tradeMinMax.getHighest());

        return tradeMinMax;
    }

}
