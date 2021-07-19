package com.luv2code.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "total_price")
    private BigDecimal total_price;

    @Column(name = "status")
    private String status;

    @Column(name = "data_created")
    @CreationTimestamp
    private Date dataCreated;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name = "customer")
    private Customer customer;
}
