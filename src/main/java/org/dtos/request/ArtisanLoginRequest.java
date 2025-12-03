package org.dtos.request;

import lombok.Data;

@Data
public class ArtisanLoginRequest {
    private String password;
    private String email;
}
