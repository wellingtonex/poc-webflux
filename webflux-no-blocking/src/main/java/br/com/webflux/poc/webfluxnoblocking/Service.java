package br.com.webflux.poc.webfluxnoblocking;

import br.com.webflux.poc.commons.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@org.springframework.stereotype.Service
public class Service {

    public Mono<String> generateName() {
        return Mono.fromSupplier(() -> {
            Util.logThreadInfo("Service");
            Util.sleepSeconds(1);
            return Util.faker().name().fullName();
        }).subscribeOn(Schedulers.boundedElastic());
    }

    public Flux<Person> generateNames() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(2))
                .map(i -> new Person(i, Util.faker().name().fullName()));
    }
}
