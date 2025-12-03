package org.example.tradeBridge.dtos.requests;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterAdminRequest {
    private String fullName;
    private String email;
    private String userName;
    private String password;
}
