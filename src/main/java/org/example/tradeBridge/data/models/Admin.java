package org.example.tradeBridge.data.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Admin {
    String id;
    String fullName;
    String email;
    String userName;
    String password;


}
