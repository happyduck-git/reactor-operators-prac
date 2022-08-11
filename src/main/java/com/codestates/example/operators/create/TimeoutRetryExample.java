package com.codestates.example.operators.create;

import com.codestates.example.operators.coffee.Coffee;
import com.codestates.example.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Collectors;

@Slf4j
public class TimeoutRetryExample {
    public static void main(String[] args) throws InterruptedException {

        getCoffees()
                //Set인 이유는 재구독 시 중복되는 데이터를 제거하기 위함!
                .collect(Collectors.toSet())
                .subscribe(bookSet -> bookSet
                        .stream()
                        .forEach(data ->
                                log.info("{} : {}", data.getKorName(), data.getPrice())));


        Thread.sleep(12000);

    }

    private static Flux<Coffee> getCoffees() {
        final int[] count = {0};
        return Flux.fromIterable(SampleData.coffeeList)
                .delayElements(Duration.ofMillis(500)) //emit을 delay하는 operator
                .map(coffee -> {
                    try {
                        count[0]++;
                        if(count[0] == 3) { //3번째 emit되는 정보를 2초 더 지연
                            Thread.sleep(2000);
                        }
                    } catch (InterruptedException e) {}

                    return coffee;
        })
                .timeout(Duration.ofSeconds(2)) //3번째 data는 2.5초 지연되어 onError Signal event 발생
                .retry(1) //하지만 sequence가 종료되지 않고 retry()를 이용해 1회 재구독(처음부터 재구독!)하여 sequence 재시작
                .doOnNext(coffee -> log.info("# getCoffees > doOnNext: {}, {}",
                        coffee.getKorName(), coffee.getPrice()));
    }
}
