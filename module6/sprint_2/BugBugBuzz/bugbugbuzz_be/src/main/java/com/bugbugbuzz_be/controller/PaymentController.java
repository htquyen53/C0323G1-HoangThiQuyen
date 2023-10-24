package com.bugbugbuzz_be.controller;

import com.bugbugbuzz_be.model.payment.Payment;
import com.bugbugbuzz_be.model.payment.PaymentRequest;
import com.bugbugbuzz_be.service.payment.IPaymentService;
import com.bugbugbuzz_be.service.product.IPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final IPaymentService paymentService;
    @PostMapping("/createPayment")
    public ResponseEntity<?> createNewPayment (@RequestBody PaymentRequest request) {
        Payment savedPayment = paymentService.createPayment(request);
        if (savedPayment!=null) {
            return  ResponseEntity.ok(savedPayment);
        }
        return ResponseEntity.noContent().build();
    }
}
