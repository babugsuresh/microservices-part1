package com.gsb.demo.configuration;

import com.gsb.demo.handler.HelloWorldHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfiguration {

    @Bean
    RouterFunction<ServerResponse> routerFunction(HelloWorldHandler helloWorldHandler) {
        return RouterFunctions.route()
                .GET("/helloworld", accept(MediaType.TEXT_PLAIN), helloWorldHandler::helloworld)
                .build();
    }

}
