package com.codestates.example.operators.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@Slf4j
public class LogExample {
    public static void main(String[] args) {
        Flux.fromStream(Stream.of(200, 300, 400, 500, 600))
                .log()
                .reduce((a,b) -> a+b)
                .log()
                .subscribe(System.out::println);
    }
}
