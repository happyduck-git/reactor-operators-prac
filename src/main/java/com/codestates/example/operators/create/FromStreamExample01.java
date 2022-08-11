package com.codestates.example.operators.create;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.stream.Stream;

public class FromStreamExample01 {

    public static void main(String[] args) {
        int[] testArr = {1,2,3,4,5};
        //fromStream()은 Stream을 전달받아
        Flux.fromStream(Arrays.stream(testArr).boxed())
                .reduce((a,b) -> a+b)
                .subscribe(System.out::println);
    }

}
