package org.example.tradeBridge.services;

import org.example.tradeBridge.data.models.Admin;
import org.example.tradeBridge.dtos.requests.AdminConfirmPaymentRequest;
import org.example.tradeBridge.dtos.requests.AdminViewCustomerRequest;
import org.example.tradeBridge.dtos.requests.LoginAdminRequest;
import org.example.tradeBridge.dtos.requests.RegisterAdminRequest;
import org.example.tradeBridge.dtos.response.*;

import java.util.List;

public interface AdminService {
    RegisterAdminResponse registerAdmin(RegisterAdminRequest request);
    LoginAdminResponse loginAdmin(LoginAdminRequest request);
    AdminViewCustomerResponse viewCustomer(AdminViewCustomerRequest request);
    List<ViewAllRegisteredCustomersResponse> getAllRegisteredCustomers();
    List<AdminViewAllBookedArtisans> getAllBookedArtisans();
    AdminConfirmPaymentResponse confirmPayment(AdminConfirmPaymentRequest request);
}
