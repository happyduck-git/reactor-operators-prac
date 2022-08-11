package com.codestates.example.operators.create;

import com.codestates.example.operators.coffee.Coffee;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class ErrorExample {
    public static void main(String[] args) {
        Mono.justOrEmpty(findVerifiedCoffee())
                .switchIfEmpty(Mono.error(new RuntimeException("Coffee not found")))
                .subscribe(data -> log.info("{} : {}", data.getKorName(), data.getPrice()),
                        error -> log.error("# onError: {}", error.getMessage()));
    }
    private static Coffee findVerifiedCoffee() {
        return null;
    }
}
