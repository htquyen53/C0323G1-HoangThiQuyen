package com.bugbugbuzz_be.service.payment;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.payment.Payment;
import com.bugbugbuzz_be.model.payment.PaymentRequest;

import java.util.List;

public interface IPaymentService {
    Payment createPayment(PaymentRequest request);
    List<Payment> getAll(AppUser appUser);
}
