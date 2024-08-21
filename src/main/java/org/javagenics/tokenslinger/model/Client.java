package org.javagenics.tokenslinger.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    private String name;
    private String cpf;
    private String email;
    private String password;
    private String userType = "client";
}
