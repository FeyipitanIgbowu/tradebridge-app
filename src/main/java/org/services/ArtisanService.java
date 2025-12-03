package org.services;

import org.dtos.request.ArtisanLoginRequest;
import org.dtos.request.ArtisanSignUpRequest;
import org.dtos.request.ArtisanUpdateRequest;
import org.dtos.response.ArtisanLoginResponse;
import org.dtos.response.ArtisanResponse;
import org.dtos.response.ArtisanSignUpResponse;

import java.util.List;

public interface ArtisanService {

    ArtisanSignUpResponse signup(ArtisanSignUpRequest request);

    ArtisanLoginResponse login(ArtisanLoginRequest request);

    ArtisanResponse updateProfile(String artisanId, ArtisanUpdateRequest request);

    ArtisanResponse getArtisanById(String artisanId);

    List<ArtisanResponse> getAllArtisans();

    List<ArtisanResponse> getAvailableArtisans();

    List<ArtisanResponse> getBookedArtisans();
}
