package org.dtos.request;

import lombok.Data;

@Data
public class RegisterCustomerRequest {

    private String fullName;
    private String email;
    private String password;
    private String contact;


}
