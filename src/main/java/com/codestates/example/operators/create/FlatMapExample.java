package com.codestates.example.operators.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class FlatMapExample {
    public static void main(String[] args) throws InterruptedException{
        //flatMap()은 하나의 data가 들어올 때마다 새로운 Sequence가 생성된다.
        //(data 하나 당 하나의 sequence 생성)

        Flux.range(2,6)
                .flatMap(dan -> Flux.range(1,9)
                        .publishOn(Schedulers.parallel())
                        .map(num -> dan + " x " + num + " = " + dan*num))
                .subscribe(log::info);

        Thread.sleep(1000L);
    }
}
