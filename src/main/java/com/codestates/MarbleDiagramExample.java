package com.codestates;

import reactor.core.publisher.Flux;

public class MarbleDiagramExample {
    public static void main(String[] args) {
        Flux.just("Green-Circle", "Orange-Circle", "Blue-Circle")
                .map(d -> d.replace("Circle", "Rectangle"))
                .subscribe(System.out::println);
    }
}
