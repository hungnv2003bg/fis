package com.example.fis.repository;

import com.example.fis.entity.Cart;
import com.example.fis.entity.Product;
import com.example.fis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart, Long> {
    public List<Cart> findCartsByCustomer(User user);

    public Optional<Cart> findCartByCustomerAndProduct(User user, Product product);
}
