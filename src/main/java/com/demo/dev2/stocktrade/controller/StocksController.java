package com.demo.dev2.stocktrade.controller;

import com.demo.dev2.stocktrade.dto.TradeMinMaxDto;
import com.demo.dev2.stocktrade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/stocks")
public class StocksController {

    @Autowired
    private TradeService tradeService;

    @GetMapping("/{symbol}/price")
    public ResponseEntity<TradeMinMaxDto> getTradeMinMaxBySymbolInDateRange(
            @PathVariable String symbol,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ){
        return new ResponseEntity<>(tradeService.findTradeMinMaxBySymbol(symbol, start, end), HttpStatus.OK);
    }
}
