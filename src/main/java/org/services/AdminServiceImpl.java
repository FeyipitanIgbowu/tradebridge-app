package org.services;


import org.data.model.*;
import org.data.repositories.AdminRepository;
import org.data.repositories.BookingRepository;
import org.data.repositories.CustomerRepository;
import org.data.repositories.PaymentRepository;
import org.dtos.request.AdminConfirmPaymentRequest;
import org.dtos.request.AdminViewCustomerRequest;
import org.dtos.request.LoginAdminRequest;
import org.dtos.request.RegisterAdminRequest;
import org.dtos.response.*;
import org.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.utils.AdminMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public RegisterAdminResponse registerAdmin(RegisterAdminRequest request) {
        Admin admin = new Admin();
        admin.setEmail(request.getEmail());
        admin.setFullName(request.getFullName());
        admin.setUserName(request.getUserName());
        String hashPassword = passwordEncoder.encode(request.getPassword());
        admin.setPassword(hashPassword);
        Admin savedAdmin = adminRepository.save(admin);

        return AdminMapper.toRegisterAdminResponse(savedAdmin);

    }

    @Override
    public LoginAdminResponse loginAdmin(LoginAdminRequest request) {
        Optional<Admin> foundAdmin = adminRepository.findByUserName(request.getUserName());
        if(foundAdmin.isEmpty()){
            throw new AdminNotFoundException("Admin not found");
        }
        String checkPassword = foundAdmin.get().getPassword();
        if(!passwordEncoder.matches(request.getPassword(),checkPassword)){
            throw new IncorrectPasswordException("Password is incorrect");
        }
        return AdminMapper.toLoginAdminResponse(foundAdmin.get());
    }

    @Override
    public AdminViewCustomerResponse viewCustomer(AdminViewCustomerRequest request) {
        Optional<Customer> customer = customerRepository.findById(request.getCustomerId());
        if(customer.isEmpty()){
            throw new CustomerNotFoundException("Customer not found");
        }
        return AdminMapper.toAdminViewCustomerResponse(customer.get());
    }

    @Override
    public List<ViewAllRegisteredCustomersResponse> getAllRegisteredCustomers() {
        List<ViewAllRegisteredCustomersResponse> responseList = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();

        for(Customer customer : customers){
            responseList.add(AdminMapper.toViewAllRegisteredCustomersResponse(customer));
        }
        return responseList;
    }

    @Override
    public List<AdminViewAllBookedArtisans> getAllBookedArtisans() {
        List<AdminViewAllBookedArtisans> responseList = new ArrayList<>();
        List<Booking> bookings = bookingRepository.findAll();
        for(Booking booking : bookings){
            responseList.add(AdminMapper.toViewAllBookedArtisans(booking));
        }
        return responseList;

    }

    @Override
    public AdminConfirmPaymentResponse confirmPayment(AdminConfirmPaymentRequest request) {
        Booking booking = bookingRepository.findById(request.getBookingId()).orElse(null);
        if(booking == null){
            throw new BookingNotFoundException("Booking not found");
        }

        Payment payment = paymentRepository.findById(request.getPaymentId()).orElse(null);
        if(payment == null){
            throw new PaymentNotFoundException("Payment not found");
        }
        if(!payment.getBookingId().equals(request.getBookingId())){
            throw new PaymentIDNotMatched("Payment ID not matched");
        }
        if(payment.getPaymentStatus().equals(PaymentStatus.Confirmed)){
            throw new PaymentAlreadyConfirmedException("Payment already confirmed");
        }
        payment.setPaymentStatus(PaymentStatus.Confirmed);
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);

        booking.setBookingStatus(Status.CONFIRMED);
        bookingRepository.save(booking);

        return AdminMapper.toAdminConfirmPaymentResponse(payment);
    }

}
