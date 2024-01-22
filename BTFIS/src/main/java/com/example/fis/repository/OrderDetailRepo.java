package com.example.fis.repository;


import com.example.fis.entity.Order;
import com.example.fis.entity.OrderDetail;
import com.example.fis.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
//    public List<OrderDetail> findOrderDetailByByOrder(Order order);
//
//    public Optional<OrderDetail> findOrderDetailByByOrderandPAndProduct(Order order, Product product);

}
