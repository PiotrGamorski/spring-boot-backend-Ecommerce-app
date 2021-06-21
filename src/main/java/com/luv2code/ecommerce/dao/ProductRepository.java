package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // This is a query method since it starts with findBy - don't need to write your own SQL!
    // Spring will also generate the following endpoint: http://localhost:8080/api/products/search/findByCategoryId?id=...
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    // SELECT * FROM Product p WHERE P.name LIKE CONCAT('%', :name, '%') -- Spring processes this select behind the scene
    // Spring will create endpoint:  http://localhost:8080/api/products/search/findByNameContaining?name=...
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
