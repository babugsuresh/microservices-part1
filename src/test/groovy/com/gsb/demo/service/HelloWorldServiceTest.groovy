package com.gsb.demo.service

import reactor.test.StepVerifier
import spock.lang.Specification
import static org.assertj.core.api.Assertions.assertThat

/**
 * Service layer is expected to create Hello world and return when we make a method call,
 * we then verify if it is as expected or not.
 */

class HelloWorldServiceTest extends Specification {

    private def helloWorldService = new HelloWorldService()

    def 'Create HelloWorld'(){
        expect:
        StepVerifier.create(helloWorldService.helloworld())
        .assertNext(s->{
            assertThat(s.equals("Hello World!"))
        }).verifyComplete()
    }

}
