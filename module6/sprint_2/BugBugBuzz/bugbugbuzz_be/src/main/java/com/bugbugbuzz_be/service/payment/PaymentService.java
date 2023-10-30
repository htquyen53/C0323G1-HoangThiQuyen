package com.bugbugbuzz_be.service.payment;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.payment.Payment;
import com.bugbugbuzz_be.model.payment.PaymentRequest;
import com.bugbugbuzz_be.model.product.Package;
import com.bugbugbuzz_be.repository.payment.IPaymentRepository;
import com.bugbugbuzz_be.service.product.IPackageService;
import com.bugbugbuzz_be.service.user.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService{
    private final IPaymentRepository paymentRepository;
    private final IAppUserService appUserService;
    private final IPackageService packageService;
    @Override
    public Payment createPayment(PaymentRequest request) {
        Optional<AppUser> appUser = Optional.ofNullable(appUserService.getAppUserByUsername(request.getUsername()));
        Optional<Package> selectedPackage = Optional.ofNullable(packageService.findById(request.getPackageId()));
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        var newPayment = Payment.builder()
                .appUser(appUser.get())
                .aPackage(selectedPackage.get())
                .paymentDate(formattedDateTime)
                .orderId(request.getOrderId())
                .status(true)
                .build();
        return paymentRepository.save(newPayment);
    }

    @Override
    public List<Payment> getAll(AppUser appUser) {
        return paymentRepository.findPaymentByAppUser(appUser);
    }
}
