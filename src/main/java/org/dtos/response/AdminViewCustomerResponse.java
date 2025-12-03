package org.dtos.response;

import lombok.Data;

@Data
public class AdminViewCustomerResponse {
    private String customerId;
    private String fullName;
    private String email;
    private String userName;
}
