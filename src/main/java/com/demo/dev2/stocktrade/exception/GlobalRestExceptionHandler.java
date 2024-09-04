package com.demo.dev2.stocktrade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(value = TradeExistException.class)
    public ResponseEntity<ApiError> tradeExistException(TradeExistException exception){
        ApiError apiError = new ApiError(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TradeDoesNotExistException.class)
    public ResponseEntity<ApiError> tradeDoesNotExistException(TradeDoesNotExistException exception){
        ApiError apiError = new ApiError(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TradeUnavailableException.class)
    public ResponseEntity<ApiError> tradeUnavailableException(TradeUnavailableException exception){
        ApiError apiError = new ApiError(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserDoesNotExistException.class)
    public ResponseEntity<ApiError> tradeDoesNotExistException(UserDoesNotExistException exception){
        ApiError apiError = new ApiError(exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
