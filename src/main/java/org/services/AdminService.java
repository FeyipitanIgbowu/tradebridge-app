package org.services;

import org.dtos.request.AdminConfirmPaymentRequest;
import org.dtos.request.AdminViewCustomerRequest;
import org.dtos.request.LoginAdminRequest;
import org.dtos.request.RegisterAdminRequest;
import org.dtos.response.*;

import java.util.List;

public interface AdminService {
        RegisterAdminResponse registerAdmin(RegisterAdminRequest request);
        LoginAdminResponse loginAdmin(LoginAdminRequest request);
        AdminViewCustomerResponse viewCustomer(AdminViewCustomerRequest request);
        List<ViewAllRegisteredCustomersResponse> getAllRegisteredCustomers();
        List<AdminViewAllBookedArtisans> getAllBookedArtisans();
        AdminConfirmPaymentResponse confirmPayment(AdminConfirmPaymentRequest request);
    }
