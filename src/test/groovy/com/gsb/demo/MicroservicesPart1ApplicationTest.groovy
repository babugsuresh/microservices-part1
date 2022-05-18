package com.gsb.demo

import com.gsb.demo.configuration.RouterConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

/**
 * This class test will ensure RouterConfiguration bean
 * is loaded or not, so that we can use this bean.
 */

@SpringBootTest
class MicroservicesPart1ApplicationTest extends Specification {

    @Autowired
    private RouterConfiguration routerConfiguration;

    def 'Verify Context load'(){
        expect:
        true
    }
}
