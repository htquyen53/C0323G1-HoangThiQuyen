package com.personalproject1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private Integer productTypeId;
    @Column(name = "product_name",nullable = false)
    private String productTypeName;
    @OneToMany(mappedBy = "productType")
    private Set<Product> productSet;

}
