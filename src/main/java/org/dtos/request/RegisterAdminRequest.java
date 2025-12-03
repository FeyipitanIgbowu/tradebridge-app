package org.dtos.request;

import lombok.Data;

@Data
public class RegisterAdminRequest {
    private String fullName;
    private String email;
    private String userName;
    private String password;
}
