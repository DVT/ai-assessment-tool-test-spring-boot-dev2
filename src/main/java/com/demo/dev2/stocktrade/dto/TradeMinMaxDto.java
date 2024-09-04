package com.demo.dev2.stocktrade.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.DecimalFormat;

public class TradeMinMaxDto {
    DecimalFormat f = new DecimalFormat("##.00");
    private String symbol;

    private float lowest;
    private float highest;

    public TradeMinMaxDto() {
    }

    public TradeMinMaxDto(String symbol, float highest, float lowest) {
        this.symbol = symbol;
        this.highest = Float.parseFloat(f.format(highest));
        this.lowest = lowest;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getHighest() {
        return highest;
    }

    public void setHighest(float highest) {

        this.highest = Float.parseFloat(f.format(highest));
    }

    public float getLowest() {
        return lowest;
    }

    public void setLowest(float lowest) {
        this.lowest = lowest;
    }
}
