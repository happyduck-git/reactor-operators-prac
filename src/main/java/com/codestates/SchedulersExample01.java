package com.codestates;

import lombok.extern.slf4j.Slf4j;

import reactor.core.publisher.Flux;


@Slf4j
public class SchedulersExample01 {
    public static void main(String[] args) {


        Flux.range(1, 10)
                .filter(n -> n % 2 == 0)
                .map(n -> n*2)
                .subscribe(d -> log.info("# onNext: {}", d));

    }
}
