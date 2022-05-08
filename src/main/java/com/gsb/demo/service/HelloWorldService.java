package com.gsb.demo.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HelloWorldService {
    public Mono<String> helloworld() {
        return Mono.just("Hello World!");
    }
}
