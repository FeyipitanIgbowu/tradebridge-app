package org.dtos.response;

import lombok.Data;

@Data
public class ViewAllRegisteredCustomersResponse {
    private String customerId;
    private String fullName;
    private String email;
    private String userName;
}
