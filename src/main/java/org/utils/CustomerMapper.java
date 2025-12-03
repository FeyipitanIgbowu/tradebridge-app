package org.utils;

import org.data.model.Customer;
import org.dtos.request.RegisterCustomerRequest;
import org.dtos.response.RegisterCustomerResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomerMapper {

    public static Customer mapRegisterCustomer(RegisterCustomerRequest request) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Customer customer = new Customer();

        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setContact(request.getContact());
        String hashPassword = passwordEncoder.encode(request.getPassword());
        customer.setPassword(hashPassword);

        return customer;
    }

        public static RegisterCustomerResponse mapRegisterCustomerResponse(Customer customer){
        RegisterCustomerResponse response = new RegisterCustomerResponse();
        response.setId(customer.getId());
        response.setEmail(customer.getEmail());
        response.setFullName(customer.getFullName());
        response.setContact(customer.getContact());

        return response;
}

}
