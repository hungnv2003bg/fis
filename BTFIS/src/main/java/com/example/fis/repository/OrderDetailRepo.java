package com.example.fis.repository;


import com.example.fis.entity.Order;
import com.example.fis.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {

    public List<OrderDetail> findOrderDetailsByOrder(Order order);
}
