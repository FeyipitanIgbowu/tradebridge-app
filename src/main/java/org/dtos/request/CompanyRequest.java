package org.dtos.request;

import lombok.Data;

@Data
public class CompanyRequest {
    private String companyName;
    private String email;
    private String description;
    private String address;
    private List<ServiceType> services;
}
