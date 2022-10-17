package com.adSquare.tiktaktoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TiktaktoeApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    /*
   Win scenario
   http://localhost:8080/tiktaktoe/startGame?player1=manu&player2=dinu
   http://localhost:8080/tiktaktoe/player/manu?row=0&column=2
   http://localhost:8080/tiktaktoe/player/dinu?row=1&column=0
   http://localhost:8080/tiktaktoe/player/manu?row=0&column=0
   http://localhost:8080/tiktaktoe/player/dinu?row=1&column=1
   http://localhost:8080/tiktaktoe/player/manu?row=0&column=1
   http://localhost:8080/tiktaktoe/player/dinu?row=1&column=2
   http://localhost:8080/tiktaktoe/player/manu?row=2&column=2

  */
    @Test
    public void runWincaseScenario() throws Exception {
        assertThat(this.restTemplate.getForObject("http://127.0.0.1:" + port + "/tiktaktoe/startGame?player1=manu&player2=dinu",
                String.class)).contains("true");
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://127.0.0.1:" + port + "/tiktaktoe/player/manu?row=0&column=2",
                String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        ResponseEntity<String> response1 = this.restTemplate.getForEntity("http://127.0.0.1:" + port + "/tiktaktoe/player/dinu?row=1&column=0",
                String.class);
        Assertions.assertEquals(response1.getStatusCode(), HttpStatus.OK);
        ResponseEntity<String> response2 = this.restTemplate.getForEntity("http://127.0.0.1:" + port + "/tiktaktoe/player/manu?row=0&column=1",
                String.class);
        Assertions.assertEquals(response2.getStatusCode(), HttpStatus.OK);
        ResponseEntity<String> response3 = this.restTemplate.getForEntity("http://127.0.0.1:" + port + "/tiktaktoe/player/dinu?row=1&column=1",
                String.class);
        Assertions.assertEquals(response3.getStatusCode(), HttpStatus.OK);
        ResponseEntity<String> response4 = this.restTemplate.getForEntity("http://127.0.0.1:" + port + "/tiktaktoe/player/manu?row=1&column=2",
                String.class);
        Assertions.assertEquals(response4.getStatusCode(), HttpStatus.OK);
        ResponseEntity<String> response5 = this.restTemplate.getForEntity("http://127.0.0.1:" + port + "/tiktaktoe/player/dinu?row=1&column=2",
                String.class);
        Assertions.assertEquals(response5.getStatusCode(), HttpStatus.OK);
        ResponseEntity<String> response6 = this.restTemplate.getForEntity("http://127.0.0.1:" + port + "/tiktaktoe/player/manu?row=2&column=2",
                String.class);
        Assertions.assertEquals(response6.getStatusCode(), HttpStatus.OK);

    }
}

