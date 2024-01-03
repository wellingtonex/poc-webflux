package br.com.webflux.poc.web;

import br.com.webflux.poc.commons.Util;

@org.springframework.stereotype.Service
public class Service {

    public String generateName() {
        Util.logThreadInfo("Service");
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
