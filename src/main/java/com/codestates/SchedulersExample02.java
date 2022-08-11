package com.codestates;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;


@Slf4j
public class SchedulersExample02 {
    public static void main(String[] args) throws InterruptedException{


        Flux.range(1, 10)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnSubscribe(subscription -> log.info("# doOnSubscribe"))
                .filter(n -> n % 2 == 0)
                .map(n -> n*2)
                .subscribe(d -> log.info("# onNext: {}", d));

        Thread.sleep(100L);
    }
}
