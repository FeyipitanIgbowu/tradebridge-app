package org.services;

import org.dtos.request.ArtisanLoginRequest;
import org.dtos.request.ArtisanSignUpRequest;
import org.dtos.response.ArtisanLoginResponse;
import org.dtos.response.ArtisanSignUpResponse;

public interface ArtisanService {

    ArtisanLoginResponse logIn(ArtisanLoginRequest request);
    ArtisanSignUpResponse signUp(ArtisanSignUpRequest request);


}
