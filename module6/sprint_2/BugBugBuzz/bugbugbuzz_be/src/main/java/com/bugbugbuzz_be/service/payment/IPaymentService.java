package com.bugbugbuzz_be.service.payment;

import com.bugbugbuzz_be.model.payment.Payment;
import com.bugbugbuzz_be.model.payment.PaymentRequest;

public interface IPaymentService {
    Payment createPayment(PaymentRequest request);
}
