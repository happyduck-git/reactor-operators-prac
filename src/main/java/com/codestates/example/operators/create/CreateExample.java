package com.codestates.example.operators.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class CreateExample {
    private static List<Integer> source = Arrays.asList(1,3,5,7,9,11, 13, 15, 17, 19);

    public static void main(String[] args) {

        //create()는 FluxSink라는 람다 파라미터를 가지는 람다 표현식이다.
        //FluxSink는 programming 방식으로 직접 Signal 이벤트를 발생시켜 sequence를 진행하도록 해주는 기능.
        //create() 내부에서 FluxSink의 객체를 통해 모든 작업을 진행행
       Flux.create((FluxSink<Integer> sink) -> {
            sink.onRequest(n -> {
                for(int i = 0; i < source.size(); i++) {
                    sink.next(source.get(i));
                }
                sink.complete(); //source 원소를 모두 emit하였으므로 sequence 종료하기 위해 complete() 호출
            });
            sink.onDispose(() -> log.info("# clean up")); //onDispose()는 Sequence가 완전히 종료되기 직전에 호출된다.
           //onDispose()로 sequence 종료 직전 후처리 작업 가능
        }).subscribe(data -> log.info("# onNext: {}", data));
    }

}
