package org.controllers;

import org.dtos.request.CustomerLoginRequest;
import org.dtos.request.RegisterCustomerRequest;
import org.dtos.response.CustomerLoginResponse;
import org.dtos.response.RegisterCustomerResponse;
import org.services.CustomerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServices customerService;

    public CustomerController(CustomerServices customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterCustomerResponse> register(
            @RequestBody RegisterCustomerRequest request
    ) {
        return ResponseEntity.ok(customerService.registerCustomer(request));
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerLoginResponse> login(
            @RequestBody CustomerLoginRequest request
    ) {
        return ResponseEntity.ok(customerService.loginCustomer(request));
    }
}