package com.demo.dev2.stocktrade.mapper;

import com.demo.dev2.stocktrade.dto.TradeDto;
import com.demo.dev2.stocktrade.dto.UserDto;
import com.demo.dev2.stocktrade.model.Trade;
import com.demo.dev2.stocktrade.model.User;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Mapper {

    public static Trade mapToTrade(TradeDto tradeDto){
        ZoneId zoneId = ZoneId.of("UTC-4");

        return new Trade(
                tradeDto.getId(),
                tradeDto.getType(),
                Mapper.mapToUser(tradeDto.getUser()),
                tradeDto.getSymbol(),
                tradeDto.getShares(),
                tradeDto.getPrice(),
                ZonedDateTime.of(tradeDto.getTimestamp(), zoneId)
        );
    }

    public static TradeDto mapToTradeDto(Trade trade){
        ZoneId zoneId = ZoneId.of("UTC-4");

        return new TradeDto(
                trade.getId(),
                trade.getType(),
                Mapper.mapToUserDto(trade.getUser()),
                trade.getSymbol(),
                trade.getShares(),
                trade.getPrice(),
                trade.getTimestamp().withZoneSameInstant(zoneId).toLocalDateTime()
        );
    }

    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getName()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName()
        );
    }
}
