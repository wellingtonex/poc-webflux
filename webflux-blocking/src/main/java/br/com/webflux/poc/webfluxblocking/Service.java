package br.com.webflux.poc.webfluxblocking;

import br.com.webflux.poc.commons.Util;
import reactor.core.publisher.Mono;

@org.springframework.stereotype.Service
public class Service {

    public Mono<String> generateName() {
        Util.logThreadInfo("Controller");
        Util.sleepSeconds(1);
        String fullName = Util.faker().name().fullName();
        return Mono.just(fullName);
    }
}
