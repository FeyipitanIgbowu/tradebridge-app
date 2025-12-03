package org.utils;

import org.data.model.Artisan;
import org.dtos.response.ArtisanLoginResponse;
import org.dtos.response.ArtisanResponse;
import org.dtos.response.ArtisanSignUpResponse;

public class ArtisanMapper {

    public static ArtisanResponse toArtisanResponse(Artisan artisan) {
        ArtisanResponse response = new ArtisanResponse();
        response.setId(artisan.getId());
        response.setFullName(artisan.getFullName());
        response.setEmail(artisan.getEmail());
        response.setServiceType(artisan.getServiceType());
        response.setAvailable(artisan.isAvailable());
        return response;
    }

    public static ArtisanSignUpResponse toSignupResponse(Artisan artisan) {
        ArtisanSignUpResponse response = new ArtisanSignUpResponse();
        response.setArtisanId(artisan.getId());
        response.setMessage("Signup successful");
        response.setStatus(String.valueOf(artisan.getServiceType()));
        return response;
    }

    public static ArtisanLoginResponse toLoginResponse(Artisan artisan) {
        ArtisanLoginResponse response = new ArtisanLoginResponse();
        response.setArtisanId(artisan.getId());
        response.setMessage("Login successful");
        return response;
    }
}
