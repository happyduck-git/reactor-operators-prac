package com.codestates.example.operators.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ConcatExample {
    public static void main(String[] args) {
        //두 개의 Flux Sequence를 전달했기 때문에 두 개의 Sequence를 이어 붙여서 논리적으로 하나의 Sequence로 동작하게 된다.
        Flux.concat(Flux.just("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
                        Flux.just("Saturday", "Sunday"))
                .subscribe(System.out::println);
    }
}
