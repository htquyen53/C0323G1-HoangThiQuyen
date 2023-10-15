package com.bugbugbuzz_be.model.payment;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.product.Package;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "date")
    private String paymentDate;

    @ManyToOne
    @JoinColumn(name="package_id", referencedColumnName = "id")
    private Package aPackage;
    @ManyToOne
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;

}
