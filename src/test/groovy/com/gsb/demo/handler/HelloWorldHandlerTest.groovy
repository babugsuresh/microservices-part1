package com.gsb.demo.handler

import com.gsb.demo.configuration.RouterConfiguration
import com.gsb.demo.service.HelloWorldService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono
import spock.lang.Specification

/**
 * Here we are testing Handler layer method, Add all Webflux annotation,
 * load all components required for your test case to pass,
 * Autowire beans and then using WebClient we can make a test and verify.
 */

@WebFluxTest
@ContextConfiguration(classes = [RouterConfiguration, HelloWorldHandler, HelloWorldService])
class HelloWorldHandlerTest extends Specification {

    @Autowired
    private HelloWorldService helloWorldService

    @Autowired
    private WebTestClient webTestClient

    def 'Verify helloworld returned OK'(){
        given:
        String response = 'Hello World!'

        and:
        helloWorldService.helloworld() >> Mono.just(response)

        expect:
        webTestClient.get()
                    .uri('/helloworld')
                    .accept(MediaType.TEXT_PLAIN)
                    .exchange()
                    .expectStatus().is2xxSuccessful()
                    .expectBody(String.class).isEqualTo("Hello World!")

    }

}
