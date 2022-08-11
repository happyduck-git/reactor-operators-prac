package com.codestates.example.operators.create;

import com.codestates.example.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FromIterableExample01 {
    public static void main(String[] args) {
        //fromIterable()은 List, Map, Set 등의 Collections를 parameter로 전달받아 사용 가능
        Flux.fromIterable(SampleData.coffeeList)
                .subscribe(coffee -> log.info("{} : {}", coffee.getKorName(), coffee.getPrice()));
    }
}
