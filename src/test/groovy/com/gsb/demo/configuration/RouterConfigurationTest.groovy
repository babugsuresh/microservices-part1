package com.gsb.demo.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Specification

@WebFluxTest
class RouterConfigurationTest extends Specification {

    @Autowired
    WebTestClient webClient;

    def "router function returns hello"() {
        expect:
        webClient.get().uri("/helloworld")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Hello World!")
    }

}
