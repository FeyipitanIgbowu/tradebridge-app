package org.utils;

import org.data.model.Admin;
import org.data.model.Booking;
import org.data.model.Customer;
import org.data.model.Payment;
import org.dtos.response.*;

public class AdminMapper {

    public static RegisterAdminResponse toRegisterAdminResponse(Admin admin){
        RegisterAdminResponse response = new RegisterAdminResponse();
        response.setAdminId(admin.getId());
        response.setEmail(admin.getEmail());
        response.setFullName(admin.getFullName());
        response.setUserName(admin.getUserName());

        return response;
    }

    public static LoginAdminResponse toLoginAdminResponse(Admin admin){
        LoginAdminResponse response = new LoginAdminResponse();
        response.setAdminId(admin.getId());
        response.setEmail(admin.getEmail());
        response.setUserName(admin.getUserName());

        return response;
    }

    public static AdminViewCustomerResponse toAdminViewCustomerResponse(Customer customer){
        AdminViewCustomerResponse response = new AdminViewCustomerResponse();
        response.setCustomerId(customer.getId());
        response.setEmail(customer.getEmail());
        response.setFullName(customer.getFullName());

        return response;
    }

    public static ViewAllRegisteredCustomersResponse toViewAllRegisteredCustomersResponse(Customer customer){
        ViewAllRegisteredCustomersResponse response = new ViewAllRegisteredCustomersResponse();
        response.setCustomerId(customer.getId());
        response.setEmail(customer.getEmail());
        response.setFullName(customer.getFullName());

        return response;
    }

    public static AdminViewAllBookedArtisans toViewAllBookedArtisans(Booking booking){
        AdminViewAllBookedArtisans response = new AdminViewAllBookedArtisans();
        response.setId(booking.getId());
        response.setArtisanId(booking.getArtisanId());
        response.setCustomerId(booking.getCustomerId());
        response.setBookingStatus(booking.getBookingStatus());
        response.setPrice(booking.getPrice());
        response.setScheduledDate(booking.getScheduledDate());

        return response;
    }

    public static AdminConfirmPaymentResponse toAdminConfirmPaymentResponse(Payment payment){
        AdminConfirmPaymentResponse response = new AdminConfirmPaymentResponse();
        response.setPaymentId(payment.getId());
        response.setCustomerId(payment.getCustomerId());
        response.setStatus(payment.getPaymentStatus());
        response.setPrice(payment.getPrice());
        response.setConfirmationDate(payment.getPaymentDate());

        return response;
    }
}
