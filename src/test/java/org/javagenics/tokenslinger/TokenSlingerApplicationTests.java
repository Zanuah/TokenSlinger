package org.javagenics.tokenslinger;

import org.javagenics.tokenslinger.model.Login;
import org.javagenics.tokenslinger.restclient.TokenSlingerApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class TokenSlingerApplicationTests {

    @LocalServerPort
    private int port;

    private final TokenSlingerApi tokenSlingerApi;

    public TokenSlingerApplicationTests(TokenSlingerApi tokenSlingerApi) {
        this.tokenSlingerApi = tokenSlingerApi;
    }

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @Test
    void signinRestTest() {
        tokenSlingerApi.login(new Login());
    }

    @Test
    void protectedRouteRestTest() {
        // Not implement YET
    }

    @Test
    void loginRestTest() {
        // Not implement YET
    }
}
