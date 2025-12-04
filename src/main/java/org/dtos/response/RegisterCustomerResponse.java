package org.dtos.response;

import lombok.Data;

@Data
public class RegisterCustomerResponse {


    private String fullName;
    private String email;
    private String id;
    private String contact;

}
