package org.dtos.request;

import lombok.Data;

@Data
public class CustomerLoginRequest {

    private String email;
    private String password;
}
