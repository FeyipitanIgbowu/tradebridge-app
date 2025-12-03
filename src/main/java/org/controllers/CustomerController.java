package org.controllers;

import org.data.model.ServiceType;
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
    public ResponseEntity<CustomerResponse> register(
            @RequestBody CustomerRequest request
    ) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchService(@RequestParam ServiceType type) {
        return ResponseEntity.ok(customerService.searchService(type));
    }
}