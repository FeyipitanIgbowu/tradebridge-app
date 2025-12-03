package org.services;

import org.dtos.request.CustomerLoginRequest;
import org.dtos.request.RegisterCustomerRequest;
import org.dtos.response.CustomerLoginResponse;
import org.dtos.response.RegisterCustomerResponse;

public interface CustomerServices extends BookingService{

    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest request);
    CustomerLoginResponse loginCustomer(CustomerLoginRequest request);
}
