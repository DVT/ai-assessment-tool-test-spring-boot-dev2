package com.demo.dev2.stocktrade.mapper;

import java.text.DecimalFormat;

public class MinMaxResponse {
    DecimalFormat df = new DecimalFormat("###.##");
    private String symbol;


    private double highest, lowest;

    public MinMaxResponse() {
    }

    public MinMaxResponse(String symbol, double highest, double lowest) {
        this.symbol = symbol;
        this.highest = Double.parseDouble(df.format(highest));
        this.lowest = Double.parseDouble(df.format(lowest));;
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

    public void setHighest(double highest) {
        this.highest = highest;
    }

    public double getLowest() {
        return lowest;
    }

    public void setLowest(double lowest) {
        this.lowest = lowest;
    }
}
