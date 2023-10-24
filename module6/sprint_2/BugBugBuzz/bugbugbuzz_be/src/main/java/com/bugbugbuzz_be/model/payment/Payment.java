package com.bugbugbuzz_be.model.payment;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.product.Package;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(columnDefinition = "datetime")
    private String paymentDate;
    private Boolean status;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="package_id", referencedColumnName = "id")
    private Package aPackage;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;

}
