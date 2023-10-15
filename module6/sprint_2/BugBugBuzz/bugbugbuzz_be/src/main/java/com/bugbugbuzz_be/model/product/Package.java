package com.bugbugbuzz_be.model.product;

import com.bugbugbuzz_be.model.payment.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "datetime")
    private String startDay;
    @Column(columnDefinition = "datetime")
    private String endDay;
    private Boolean isDeleted = false;
    private Double price;
    @OneToMany(mappedBy = "aPackage")
    private Set<Payment> paymentSet;
}
