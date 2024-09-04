package com.demo.dev2.stocktrade.controller;

import com.demo.dev2.stocktrade.dto.TradeDto;
import com.demo.dev2.stocktrade.repository.TradeRepository;
import com.demo.dev2.stocktrade.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TradeRepository tradeRepository;

    @DeleteMapping
    public ResponseEntity<List<TradeDto>> deleteEverything(){
        tradeRepository.deleteAll();
        userRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
