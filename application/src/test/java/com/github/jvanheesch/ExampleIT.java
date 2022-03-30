package com.github.jvanheesch;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Testcontainers
class ExampleIT {

    @Container
    private static final GenericContainer<?> STUBS_CONTAINER = new GenericContainer<>("docker.io/library/stubs:1.0-SNAPSHOT")
            .withExposedPorts(8080);

    @Test
    void example() {
        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("http://%s:%s/" + "hello", STUBS_CONTAINER.getHost(), STUBS_CONTAINER.getMappedPort(8080));

        String body = restTemplate.getForEntity(url, String.class).getBody();

        assertThat(body)
                .isEqualTo("world");
    }
}
