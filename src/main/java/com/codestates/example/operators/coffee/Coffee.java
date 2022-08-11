package com.codestates.example.operators.coffee;

import lombok.Getter;

@Getter
public class Coffee {

    private String korName;
    private String engName;
    private long price;
    private String coffeeCode;

    public Coffee(String korName, String engName, long price, String coffeeCode) {
        this.korName = korName;
        this.engName = engName;
        this.price = price;
        this.coffeeCode = coffeeCode;
    }

}
