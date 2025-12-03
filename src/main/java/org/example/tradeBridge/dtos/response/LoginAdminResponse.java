package org.example.tradeBridge.dtos.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginAdminResponse {
    private String adminId;
    private String userName;
    private String email;

}
