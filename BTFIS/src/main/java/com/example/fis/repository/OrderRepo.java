package com.example.fis.repository;

import com.example.fis.entity.Cart;
import com.example.fis.entity.Order;
import com.example.fis.entity.Product;
import com.example.fis.entity.User;
import com.example.fis.model.response.StatisticProduc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    public Optional<Order> findOrderByCustomer(User user);

    @Query("SELECT SUM(o.orderValue) FROM Order o " +
            "WHERE o.createDate >= :selectedDateStart and o.createDate <= :selectedDateEnd and o.statusOrder = 3")
    BigDecimal sumRevenue(@Param("selectedDateStart") LocalDateTime selectedDateStart,
                          @Param("selectedDateEnd") LocalDateTime selectedDateEnd);

    @Query("SELECT new StatisticProduc(p.nameproduct AS productName, SUM(od.quantity) AS totalSoldQuantity) " +
            "FROM orderdetail od " +
            "JOIN orders o ON od.orderid = o.id " +
            "JOIN product p ON od.productid = p.id " +
            "WHERE o.status = 3 " +
            "      AND o.createdate BETWEEN :selectedDateStart AND :selectedDateEnd " +
            "GROUP BY p.nameproduct")
    List<StatisticProduc> getProductSoldQuantityBetweenDates(
            @Param("selectedDateStart") LocalDateTime selectedDateStart,
            @Param("selectedDateEnd") LocalDateTime selectedDateEnd);

}
