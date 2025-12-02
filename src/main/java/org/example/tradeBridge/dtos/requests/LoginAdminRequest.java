package org.example.tradeBridge.dtos.requests;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginAdminRequest {
    private String userName;
    private String password;
}
