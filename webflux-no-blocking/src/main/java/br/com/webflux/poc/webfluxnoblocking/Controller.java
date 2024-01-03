package br.com.webflux.poc.webfluxnoblocking;

import br.com.webflux.poc.commons.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class Controller {

    private final Service service;

    @GetMapping("/name")
    public Mono<String> generateName() {
        Util.logThreadInfo("Controller");
        return service.generateName();
    }

    @GetMapping(value = "names", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Person> generateNames() {
        return service.generateNames();
    }

    @GetMapping(value = "names/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> generateNamesStream() {
        return service.generateNames();
    }

 }
