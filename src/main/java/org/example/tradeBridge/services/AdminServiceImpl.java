package org.example.tradeBridge.services;

import org.example.tradeBridge.data.models.*;
import org.example.tradeBridge.data.repository.AdminRepository;
import org.example.tradeBridge.data.repository.BookingRepository;
import org.example.tradeBridge.data.repository.CustomerRepository;
import org.example.tradeBridge.data.repository.PaymentRepository;
import org.example.tradeBridge.dtos.requests.AdminConfirmPaymentRequest;
import org.example.tradeBridge.dtos.requests.AdminViewCustomerRequest;
import org.example.tradeBridge.dtos.requests.LoginAdminRequest;
import org.example.tradeBridge.dtos.requests.RegisterAdminRequest;
import org.example.tradeBridge.dtos.response.*;
import org.example.tradeBridge.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

        RegisterAdminResponse response = new RegisterAdminResponse();
        response.setAdminId(savedAdmin.getId());
        response.setFullName(savedAdmin.getFullName());
        response.setEmail(savedAdmin.getEmail());
        response.setUserName(savedAdmin.getUserName());
        return response;

    }

    @Override
    public LoginAdminResponse loginAdmin(LoginAdminRequest request) {
        Admin foundAdmin = adminRepository.findByUserName(request.getUserName());
        if(foundAdmin == null){
            throw new AdminNotFoundException("Admin not found");
        }
        String checkPassword = foundAdmin.getPassword();
        if(!passwordEncoder.matches(request.getPassword(),checkPassword)){
            throw new PasswordIncorrectException("Password is incorrect");
        }
        LoginAdminResponse response = new LoginAdminResponse();
        response.setAdminId(foundAdmin.getId());
        response.setEmail(foundAdmin.getEmail());
        response.setUserName(foundAdmin.getUserName());
        return response;

    }

    @Override
    public AdminViewCustomerResponse viewCustomer(AdminViewCustomerRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        if(customer == null){
            throw new CustomerNotFoundException("Customer not found");
        }
        AdminViewCustomerResponse response = new AdminViewCustomerResponse();
        response.setCustomerId(customer.getId());
        response.setEmail(customer.getEmail());
        response.setFullName(customer.getFullName());

        return response;
    }

    @Override
    public List<ViewAllRegisteredCustomersResponse> getAllRegisteredCustomers() {
        List<ViewAllRegisteredCustomersResponse> responseList = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();

        for(Customer customer : customers){

            ViewAllRegisteredCustomersResponse response = new ViewAllRegisteredCustomersResponse();
            response.setCustomerId(customer.getId());
            response.setEmail(customer.getEmail());
            response.setFullName(customer.getFullName());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<AdminViewAllBookedArtisans> getAllBookedArtisans() {
        List<AdminViewAllBookedArtisans> responseList = new ArrayList<>();
        List<Booking> bookings = bookingRepository.findAll();
        for(Booking booking : bookings){
            AdminViewAllBookedArtisans response = new AdminViewAllBookedArtisans();
            response.setId(booking.getId());
            response.setCustomerId(booking.getCustomerId());
            response.setArtisanId(booking.getArtisanId());
            response.setBookingStatus(booking.getBookingStatus().getDescription());
            response.setPrice(booking.getPrice());
            response.setScheduledDate(booking.getScheduledDate());

            responseList.add(response);
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
        if(payment.getStatus().equals(PaymentStatus.SUCCESS)){
            throw new PaymentAlreadyConfirmedException("Payment already confirmed");
        }
        payment.setStatus(PaymentStatus.SUCCESS);
        payment.setPaymentDate(LocalDateTime.now());
        paymentRepository.save(payment);

        booking.setBookingStatus(BookingStatus.CONFIRMED);
        bookingRepository.save(booking);

        AdminConfirmPaymentResponse response = new AdminConfirmPaymentResponse();
            response.setPaymentId(payment.getId());
            response.setCustomerId(payment.getCustomerId());
            response.setStatus(payment.getStatus());
            response.setPrice(payment.getPrice());
            response.setConfirmationDate(LocalDateTime.now());

        return response;
    }

}
