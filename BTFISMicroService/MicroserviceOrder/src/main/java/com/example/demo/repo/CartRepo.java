package com.example.demo.repo;


import com.example.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
   List<Cart> findByCustomerId(Long customerId);
   Optional<Cart> findCartByCustomerIdAndProductId(Long customerId, Long productId);
}
