package com.codestates;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class HelloReactiveExample {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("MainThread", "Hi")
                        .subscribe(s -> System.out.println(s));

        Flux.just("Hello", "Reactor") //just는 data emit하는 Publisher 역할
                .map(m -> m.toUpperCase())
                .publishOn(Schedulers.parallel()) //publishOn() == Thread 관리자 역할을 하는 Scheduler를 지정하는 Operator
                .subscribe(d->log.info("# onNext: {}",d ), //consuming data
                        e -> System.out.println(e.getMessage()), //error handler
                        () -> System.out.println("# onComplete")); //completion handler

        Thread.sleep(100L);
        //Scheduler를 지정하면 main thread 이외에 별도의 thread가 하나 더 생긴다.
        //Reactor에서 Scheduler로 지정한 thread는 모두 demon thread이기 때문에
        //main thread가 종료되면 동시에 종료된다.
        //따라서 main thread를 0.1초(100L) 정도 동작 지연을 시키면
        //그 0.1sec 사이에 Scheduler로 지정한 demon thread를 통해
        //Reactor Sequence가 정상 동작을 하게 된다.
    }
}
