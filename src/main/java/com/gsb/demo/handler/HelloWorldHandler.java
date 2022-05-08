package com.gsb.demo.handler;

import com.gsb.demo.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class HelloWorldHandler {

    private final HelloWorldService helloWorldService;

    public Mono<ServerResponse> helloworld(ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromProducer(helloWorldService.helloworld(), String.class));
    }
}
