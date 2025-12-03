package org.dtos.request;

import lombok.Data;
import org.data.model.ServiceType;

@Data
public class ArtisanUpdateRequest {
    private String fullName;
    private ServiceType serviceType;
}
