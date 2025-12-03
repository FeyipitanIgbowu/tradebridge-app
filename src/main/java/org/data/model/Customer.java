package org.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {

    @Id
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String contact;
}

