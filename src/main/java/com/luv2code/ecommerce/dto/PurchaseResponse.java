package com.luv2code.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

    // Lombok Data generates constructors, but only for final fields!
    private final String orderTrackingNumber;
}
