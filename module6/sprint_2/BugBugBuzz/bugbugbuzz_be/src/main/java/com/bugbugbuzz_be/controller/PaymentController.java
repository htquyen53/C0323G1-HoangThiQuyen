package com.bugbugbuzz_be.controller;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.payment.Payment;
import com.bugbugbuzz_be.model.payment.PaymentRequest;
import com.bugbugbuzz_be.service.payment.IPaymentService;
import com.bugbugbuzz_be.service.user.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final IPaymentService paymentService;
    private final IAppUserService appUserService;
    @PostMapping("/createPayment")
    public ResponseEntity<?> createNewPayment (@RequestBody PaymentRequest request) {
        Payment savedPayment = paymentService.createPayment(request);
        if (savedPayment!=null) {
            return  ResponseEntity.ok(savedPayment);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list/{username}")
    public ResponseEntity<?> getListPayment (@PathVariable String username) {
        AppUser appUser = appUserService.getAppUserByUsername(username);
        List<Payment> payments = paymentService.getAll(appUser);
        if (payments.size()>0) {
            return ResponseEntity.ok(payments);
        }
        return ResponseEntity.noContent().build();
    }
}
