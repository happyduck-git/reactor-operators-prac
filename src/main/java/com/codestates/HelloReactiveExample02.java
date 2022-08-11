package com.codestates;

import reactor.core.publisher.Mono;

public class HelloReactiveExample02 {
    public static void main(String[] args) {
        Mono.just("Hello, Reactive")
                .subscribe(m -> System.out.println(m));
    }
}
