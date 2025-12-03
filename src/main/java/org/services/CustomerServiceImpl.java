package org.services;

import org.data.model.Customer;
import org.data.repositories.CustomerRepository;
import org.dtos.request.CustomerLoginRequest;
import org.dtos.request.RegisterCustomerRequest;
import org.dtos.response.CustomerLoginResponse;
import org.dtos.response.RegisterCustomerResponse;
import org.exceptions.CustomerAlreadyExist;
import org.exceptions.IncorrectLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static org.utils.CustomerMapper.mapRegisterCustomer;
import static org.utils.CustomerMapper.mapRegisterCustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest request) {

        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new CustomerAlreadyExist("Email Already Exist, Login Instead.");
        }
        Customer customer = mapRegisterCustomer(request);
        customerRepository.save(customer);

        return mapRegisterCustomerResponse(customer);
    }

    @Override
    public CustomerLoginResponse loginCustomer(CustomerLoginRequest request) {

        Optional<Customer> customer = customerRepository.findByEmail(request.getEmail());

        if (customer.isEmpty()) {
            throw new IncorrectLogin("incorrect email or password");
        }
        if (!passwordEncoder.matches(request.getPassword(), customer.get().getPassword())) {
            throw new IncorrectLogin("incorrect email or password");
        }

        return new CustomerLoginResponse("Login Successful");

    }

}