package org.data.model;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Artisan {

    @Id
    private String id;

    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private ServiceType serviceType;
    private String password;
    private boolean isAvailable;
}
