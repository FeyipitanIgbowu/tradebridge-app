package org.example.tradeBridge.data.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Customer {
    String id;
    String fullName;
    String email;
    String password;
    String phoneNumber;

}
