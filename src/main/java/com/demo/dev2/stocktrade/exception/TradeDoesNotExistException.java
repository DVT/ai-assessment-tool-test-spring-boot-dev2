package com.demo.dev2.stocktrade.exception;

public class TradeDoesNotExistException extends RuntimeException{
    public TradeDoesNotExistException(String message){
        super(message);
    }
}
