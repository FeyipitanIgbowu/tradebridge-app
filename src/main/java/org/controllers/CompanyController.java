@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PutMapping("/update")
    public ResponseEntity<CompanyResponse> updateCompany(
            @RequestBody CompanyRequest request
    ) {
        return ResponseEntity.ok(companyService.updateCompany(request));
    }

    @GetMapping
    public ResponseEntity<CompanyResponse> getCompany() {
        return ResponseEntity.ok(companyService.getCompany());
    }

    @GetMapping("/available-artisans")
    public ResponseEntity<?> checkArtisanAvailability() {
        return ResponseEntity.ok(companyService.checkArtisansAvailability());
    }

    @GetMapping("/booked-artisans")
    public ResponseEntity<?> viewBookedArtisans() {
        return ResponseEntity.ok(companyService.viewBookedArtisans());
    }

    @PostMapping("/confirm-payment/{bookingId}")
    public ResponseEntity<?> confirmPayment(@PathVariable String bookingId) {
        companyService.confirmPayment(bookingId);
        return ResponseEntity.ok("Payment confirmed");
    }

    @GetMapping("/customers")
    public ResponseEntity<?> viewRegisteredCustomers() {
        return ResponseEntity.ok(companyService.viewRegisteredCustomers());
    }
}
