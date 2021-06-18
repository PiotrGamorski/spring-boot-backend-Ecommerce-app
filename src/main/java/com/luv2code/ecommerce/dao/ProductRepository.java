package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // this is a query method since it starts with findBy - don't need to write your own SQL!
    // spring will also generate the following endpoint: http://localhost:8080/api/products/search/findByCategoryId?id=...
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
}
