package com.demo.dev2.stocktrade.repository;

import com.demo.dev2.stocktrade.dto.TradeMinMaxDto;
import com.demo.dev2.stocktrade.model.Trade;
import com.demo.dev2.stocktrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByUser(User user);

    List<Trade> findBySymbolAndTypeAndTimestampBetween(String symbol, String type, ZonedDateTime start, ZonedDateTime end);

    List<Trade> findAllByOrderByIdAsc();

    long countBySymbol(String symbol);

    @Query("SELECT new com.hackerrank.stocktrade.dto.TradeMinMaxDto(t.symbol, ROUND(MAX(t.price), 2), ROUND(MIN(t.price), 2)) FROM Trade t WHERE t.symbol = ?1 AND t.timestamp >= ?2 AND t.timestamp <= ?3 ")
    TradeMinMaxDto findTradeMinMax(String symbol, ZonedDateTime start, ZonedDateTime end);
}
