package com.github.jvanheesch;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class ExampleIT {
    @Test
    void example() {
        RestTemplate restTemplate = new RestTemplate();

        String body = restTemplate.getForEntity("http://localhost:8080/hello", String.class).getBody();

        System.out.println(body);
    }
}
