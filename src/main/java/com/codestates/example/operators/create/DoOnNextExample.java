package com.codestates.example.operators.create;

import com.codestates.example.operators.coffee.Coffee;
import com.codestates.example.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class DoOnNextExample {
    public static void main(String[] args) {
        Flux.fromIterable(SampleData.coffeeList)
                .doOnNext(coffee -> validateCoffee(coffee))
                .subscribe(data -> log.info("{} : {}", data.getKorName(), data.getPrice()));
    }

    public static void validateCoffee(Coffee coffee) {
        if(coffee == null) {
            throw new RuntimeException("Coffee not found");
        }
    }

}
