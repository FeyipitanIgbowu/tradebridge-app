package org.controllers;

import org.dtos.request.AdminConfirmPaymentRequest;
import org.dtos.request.AdminViewCustomerRequest;
import org.dtos.request.LoginAdminRequest;
import org.dtos.request.RegisterAdminRequest;
import org.dtos.response.*;
import org.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;

@Autowired
public AdminController(AdminService adminService) {
    this.adminService = adminService;
}

@PostMapping("/register")
public RegisterAdminResponse register(@RequestBody RegisterAdminRequest request) {
    return adminService.registerAdmin(request);
}
@PostMapping("/login")
 public LoginAdminResponse login(@RequestBody LoginAdminRequest request) {
    return adminService.loginAdmin(request);
}
@PostMapping("/confirm-payment")
 public AdminConfirmPaymentResponse confirmPayment(@RequestBody AdminConfirmPaymentRequest request) {
    return adminService.confirmPayment(request);
}
@GetMapping("/view-all-customers")
 public ResponseEntity<List<ViewAllRegisteredCustomersResponse>> viewAllCustomers() {
    List<ViewAllRegisteredCustomersResponse> customers = adminService.getAllRegisteredCustomers();
    return ResponseEntity.ok(customers);
}
@GetMapping("/view-all-artisan")
public ResponseEntity<List<AdminViewAllBookedArtisans>> viewAllArtisan(){
    List<AdminViewAllBookedArtisans> artisans = adminService.getAllBookedArtisans();
    return ResponseEntity.ok(artisans);
}
@GetMapping("/view-customer")
public ResponseEntity<AdminViewCustomerResponse> viewCustomer(@RequestBody AdminViewCustomerRequest request){
    return ResponseEntity.ok(adminService.viewCustomer(request));
}
}
