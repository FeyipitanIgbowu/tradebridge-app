package org.data.model;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Admin {

    @Id
    private String id;
    private String email;
    private String userName;
    private String password;
    private String fullName;
}
