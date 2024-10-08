package org.javagenics.tokenslinger;

import io.github.danielliu1123.httpexchange.EnableExchangeClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableExchangeClients
public class TokenSlingerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenSlingerApplication.class, args);
    }

}
