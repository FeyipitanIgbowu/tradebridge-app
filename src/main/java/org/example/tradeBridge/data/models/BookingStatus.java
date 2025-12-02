package org.example.tradeBridge.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum BookingStatus {

        PENDING("Pending approval"),
        CONFIRMED("Booking confirmed"),
        CANCELLED("Booking cancelled"),
        COMPLETED("Service completed");

        private String description;

        BookingStatus(String description) {
            this.description = description;
        }
}