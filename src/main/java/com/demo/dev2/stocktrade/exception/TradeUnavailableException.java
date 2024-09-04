package com.demo.dev2.stocktrade.exception;

public class TradeUnavailableException extends RuntimeException{
    public TradeUnavailableException(String message){
        super(message);
    }
}
