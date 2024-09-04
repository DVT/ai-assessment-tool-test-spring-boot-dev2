package com.demo.dev2.stocktrade.service;

import com.demo.dev2.stocktrade.dto.TradeDto;
import com.demo.dev2.stocktrade.dto.TradeMinMaxDto;

import java.time.LocalDate;
import java.util.List;

public interface TradeService {
    TradeDto createNewTrade(TradeDto tradeDto);

    TradeDto findOneTrade(Long id);

    List<TradeDto> findTradeByUser(Long id);

    List<TradeDto> findByTradeBySymbolAndTypeInDateRange(String symbol, String type, LocalDate start, LocalDate end);

    List<TradeDto> findAllTrades();

    TradeMinMaxDto findTradeMinMaxBySymbol(String symbol, LocalDate start, LocalDate end);
}
