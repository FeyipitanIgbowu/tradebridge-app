package org.dtos.response;

import lombok.Data;
import org.data.model.ServiceType;

@Data
public class ArtisanResponse {
    private String id;
    private String fullName;
    private String email;
    private ServiceType serviceType;
    private boolean available;
}
