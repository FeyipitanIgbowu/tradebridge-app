package org.dtos.response;

import lombok.Data;

@Data
public class RegisterAdminResponse {
    private String AdminId;
    private String fullName;
    private String email;
    private String userName;
}
