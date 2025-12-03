package org.example.tradeBridge.dtos.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterAdminResponse {
    private String AdminId;
    private String fullName;
    private String email;
    private String userName;
}
