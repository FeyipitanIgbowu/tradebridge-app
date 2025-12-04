package org.data.model;

import lombok.Getter;

@Getter
public enum ServiceType {
    PLUMBING("20000"),
    ELECTRICAL("15000"),
    PAINTING("10000");

    public final String price;

    ServiceType(String price) {
        this.price = price;
    }
}