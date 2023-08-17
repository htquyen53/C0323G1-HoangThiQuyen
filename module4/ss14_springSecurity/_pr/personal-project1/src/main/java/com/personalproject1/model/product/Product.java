package com.personalproject1.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "product_price", nullable = false)
    private Double productPrice;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_img_path")
    private String productImgPath;
    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id",nullable = false)
    private ProductType ProductType;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetail>
}

