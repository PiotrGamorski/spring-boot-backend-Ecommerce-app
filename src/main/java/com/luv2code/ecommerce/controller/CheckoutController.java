package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dao.CustomerRepository;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.entity.Customer;
import com.luv2code.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final CustomerRepository customerRepository;

    @Autowired
    public CheckoutController(CheckoutService checkoutService, CustomerRepository customerRepository){
        this.checkoutService = checkoutService;
        this.customerRepository = customerRepository;
    }

    // ENDPOINT: http://localhost:8080/api/checkout/purchase
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        // {
        // "customer": {"firstName":"...", "lastName":"..."},
        //  "shippingAddress": {...},
        // ...
        // }
        return this.checkoutService.placeOrder(purchase);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAllCustomers(){
        return ResponseEntity.ok(this.customerRepository.findAll());
    }
}
