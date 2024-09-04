package com.demo.dev2.stocktrade.exception;

public class TradeExistException extends RuntimeException{
    public TradeExistException(String message){
        super(message);
    }
}
