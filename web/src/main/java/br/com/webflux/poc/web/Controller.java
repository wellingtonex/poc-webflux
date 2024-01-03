package br.com.webflux.poc.web;

import br.com.webflux.poc.commons.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class Controller {

    private final Service service;

    @GetMapping("/name")
    public String generateName() {
        Util.logThreadInfo("Controller");
        return service.generateName();
    }
 }
