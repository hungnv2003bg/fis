package com.example.fis.repository;

import com.example.fis.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    @Query("SELECT SUM(o.orderValue) FROM Order o " +
            "WHERE o.createDate >= :selectedDateStart and o.createDate <= :selectedDateEnd")
    BigDecimal sumRevenue(@Param("selectedDateStart") LocalDateTime selectedDateStart,
                          @Param("selectedDateEnd") LocalDateTime selectedDateEnd);

}
