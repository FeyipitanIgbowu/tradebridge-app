package org.dtos.request;

import lombok.Data;
import org.data.model.ServiceType;

@Data
public class ArtisanSignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ServiceType serviceType;

}
