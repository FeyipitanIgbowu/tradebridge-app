package org.dtos.request;

import lombok.Data;

@Data
public class LoginAdminRequest {
    private String userName;
    private String password;
}
