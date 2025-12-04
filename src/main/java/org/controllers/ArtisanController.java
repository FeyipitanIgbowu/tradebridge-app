package org.controllers;

import org.dtos.request.ArtisanLoginRequest;
import org.dtos.request.ArtisanSignUpRequest;
import org.dtos.request.ArtisanUpdateRequest;
import org.dtos.response.APIResponse;
import org.dtos.response.ArtisanLoginResponse;
import org.dtos.response.ArtisanSignUpResponse;
import org.exceptions.TradeBridgeAppException;
import org.services.ArtisanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ArtisanController {

    private ArtisanService artisanService;

    @PostMapping("/artisan/register")
    public ResponseEntity<APIResponse> register(@RequestBody ArtisanSignUpRequest request) {
        try {
            return new ResponseEntity<>(new APIResponse(true, artisanService.signup(request)),HttpStatus.CREATED);
        }
        catch(TradeBridgeAppException ex){
            return new ResponseEntity<>(new APIResponse(false, ex.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/artisan/login")
    public ResponseEntity<APIResponse> login(@RequestBody ArtisanLoginRequest request){
        try {
            return new ResponseEntity<>(new APIResponse(true, artisanService.login(request)),HttpStatus.CREATED);
        }
        catch(TradeBridgeAppException ex){
            return new ResponseEntity<>(new APIResponse(false, ex.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/artisan/viewArtisan")
    public ResponseEntity<APIResponse> viewArtisan() {
        try {
            return new ResponseEntity<>(new APIResponse(true, artisanService.getAllArtisans()), HttpStatus.OK);
        }
        catch(TradeBridgeAppException ex){
            return new ResponseEntity<>(new APIResponse(false, ex.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
}
