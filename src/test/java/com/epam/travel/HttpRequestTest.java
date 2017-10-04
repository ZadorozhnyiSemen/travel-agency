package com.epam.travel;

import org.hamcrest.CoreMatchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMethod() throws Exception{
        assertThat((this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)),
                CoreMatchers.containsString("Hello"));
    }
}
