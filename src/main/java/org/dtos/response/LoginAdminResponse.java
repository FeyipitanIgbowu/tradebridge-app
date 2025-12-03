package org.dtos.response;

import lombok.Data;

@Data
public class LoginAdminResponse {
    private String adminId;
    private String userName;
    private String email;

}
