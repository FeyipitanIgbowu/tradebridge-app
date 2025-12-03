package org.exceptions;

public class ArtisanNotFoundException extends RuntimeException {
    public ArtisanNotFoundException(String message) {
        super(message);
    }
}
