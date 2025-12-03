package org.services;

import org.data.model.Artisan;
import org.data.model.ServiceType;
import org.data.repositories.ArtisanRepository;
import org.dtos.request.ArtisanLoginRequest;
import org.dtos.request.ArtisanSignUpRequest;
import org.dtos.request.ArtisanUpdateRequest;
import org.dtos.response.ArtisanLoginResponse;
import org.dtos.response.ArtisanResponse;
import org.dtos.response.ArtisanSignUpResponse;
import org.exceptions.ArtisanNotFoundException;
import org.exceptions.EmailAlreadyExistsException;
import org.exceptions.EmailNotFoundException;
import org.exceptions.IncorrectPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utils.ArtisanMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ArtisanServiceImpl implements ArtisanService {
    @Autowired
    private ArtisanRepository artisanRepository;

    public ArtisanServiceImpl(ArtisanRepository artisanRepository) {
        this.artisanRepository = artisanRepository;
    }

    @Override
    public ArtisanSignUpResponse signup(ArtisanSignUpRequest request) {

        Optional<Artisan> existing = artisanRepository.findByEmail(request.getEmail());
        if (existing.isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered");
        }

        Artisan artisan = new Artisan();
        artisan.setFullName(request.getFirstName() + " " + request.getLastName());
        artisan.setEmail(request.getEmail());
        artisan.setPassword(request.getPassword());
        artisan.setServiceType(ServiceType.valueOf(request.getServiceType().toString()));
        artisan.setAvailable(true);

        Artisan saved = artisanRepository.save(artisan);

        return ArtisanMapper.toSignupResponse(saved);
    }

    @Override
    public ArtisanLoginResponse login(ArtisanLoginRequest request) {

        Optional<Artisan> artisanOptional = artisanRepository.findByEmail(request.getEmail());

        if (artisanOptional.isEmpty()) {
            throw new EmailNotFoundException("Email not found");
        }

        Artisan artisan = artisanOptional.get();

        if (!artisan.getPassword().equals(request.getPassword())) {
            throw new IncorrectPasswordException("Incorrect password");
        }

        return ArtisanMapper.toLoginResponse(artisan);
    }

    @Override
    public ArtisanResponse updateProfile(String artisanId, ArtisanUpdateRequest request) {

        Optional<Artisan> artisanOptional = artisanRepository.findById(artisanId);

        if (!artisanOptional.isPresent()) {
            throw new ArtisanNotFoundException("Artisan not found");
        }

        Artisan artisan = artisanOptional.get();

        artisan.setFullName(request.getFullName());
        artisan.setServiceType(request.getServiceType());

        Artisan updated = artisanRepository.save(artisan);

        return ArtisanMapper.toArtisanResponse(updated);
    }

    @Override
    public ArtisanResponse getArtisanById(String artisanId) {

        Optional<Artisan> artisanOptional = artisanRepository.findById(artisanId);

        if (!artisanOptional.isPresent()) {
            throw new ArtisanNotFoundException("Artisan not found");
        }

        Artisan artisan = artisanOptional.get();

        return ArtisanMapper.toArtisanResponse(artisan);
    }

    @Override
    public List<ArtisanResponse> getAllArtisans() {
        List<Artisan> artisans = artisanRepository.findAll();
        List<ArtisanResponse> responses = new ArrayList<>();

        for (Artisan artisan : artisans) {
            responses.add(ArtisanMapper.toArtisanResponse(artisan));
        }

        return responses;
        }

    @Override
    public List<ArtisanResponse> getAvailableArtisans() {
        List<Artisan> artisans = artisanRepository.findByAvailable(true);
        List<ArtisanResponse> responses = new ArrayList<>();

        for (Artisan artisan : artisans) {
            responses.add(ArtisanMapper.toArtisanResponse(artisan));
        }

        return responses;
        }

    @Override
    public List<ArtisanResponse> getBookedArtisans() {
        return List.of();
    }
}

