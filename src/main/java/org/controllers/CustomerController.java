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
