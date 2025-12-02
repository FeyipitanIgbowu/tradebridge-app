package org.controllers;

import org.data.model.ServiceType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
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
