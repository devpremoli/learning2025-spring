package com.yt.genuinecoder.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveTutorial {

    private Mono<String> testMono() {
        return Mono
                .just("Java")
                //.log()
                ;
    }

    private Flux<String> testFlux() {
        return Flux.just("Java", "Spring", "Rust");
    }

    private Flux<String> testFluxMap() {
        return Flux.just("Java", "Spring", "Rust")
                .map(String::toUpperCase);
    }

    private Flux<String> testFluxFlatMap() {
        return Flux.just("Java", "Spring", "Rust")
                .flatMap(s -> Mono.just(s.toUpperCase()));
    }

    public Flux<String> testSkip() {
        return Flux.just("Java", "Spring", "Rust")
                //.skip(4);
                //.skip(2);
                .delayElements(Duration.ofSeconds(1)).log();
    }



    public static void main(String[] args) throws InterruptedException {

        ReactiveTutorial reactiveTutorial = new ReactiveTutorial();
        //reactiveTutorial.testMono().subscribe(System.out::println);
        //reactiveTutorial.testFlux().subscribe(System.out::println);
        //reactiveTutorial.testFluxMap().subscribe(System.out::println);
        //reactiveTutorial.testFluxFlatMap().subscribe(System.out::println);
        reactiveTutorial.testSkip().subscribe(System.out::println);
        Thread.sleep(10_000);
    }
}
