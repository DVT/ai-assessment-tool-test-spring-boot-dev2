package com.demo.dev2.stocktrade.controller;

import com.demo.dev2.stocktrade.dto.TradeDto;
import com.demo.dev2.stocktrade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {

    @Autowired
    private TradeService tradeService;

    @PostMapping
    public ResponseEntity<TradeDto> postNewTrade(@RequestBody TradeDto tradeDto){
        return new ResponseEntity<>(tradeService.createNewTrade(tradeDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TradeDto>> getAllTrades(){
        return new ResponseEntity<>(tradeService.findAllTrades(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TradeDto> getOneTrade(@PathVariable Long id){
        return new ResponseEntity<>(tradeService.findOneTrade(id), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<TradeDto>> getTradeByUser(@PathVariable Long id){
        return new ResponseEntity<>(tradeService.findTradeByUser(id), HttpStatus.OK);
    }

    @GetMapping("/stocks/{symbol}")
    public ResponseEntity<List<TradeDto>> getTradeBySymbolAndTypeInDateRange(
            @PathVariable String symbol,
            @RequestParam String type,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ){
        return new ResponseEntity<>(tradeService.findByTradeBySymbolAndTypeInDateRange(symbol, type, start, end), HttpStatus.OK);
    }
}
