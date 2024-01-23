package com.example.fis.repository;

import com.example.fis.entity.Cart;
import com.example.fis.entity.Order;
import com.example.fis.entity.Product;
import com.example.fis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    public Optional<Order> findOrderByCustomer(User user);

    @Query("SELECT SUM(o.orderValue) FROM Order o " +
            "WHERE o.createDate >= :selectedDateStart and o.createDate <= :selectedDateEnd and o.statusOrder = 5")
    BigDecimal sumRevenue(@Param("selectedDateStart") LocalDateTime selectedDateStart,
                          @Param("selectedDateEnd") LocalDateTime selectedDateEnd);

}
