package com.example.demo.entity;

import com.example.demo.enums.StatusOrder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customerid")
    private Long customer;
    @Column(name = "addressid")
    private Long address;
    @Column(name = "codeorder")
    private String codeOrder;
    @Column(name = "pay")
    private Long payId;
    @Column(name = "ship")
    private Long shipId;
    @Column(name = "note")
    private String note;
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "updatedate")
    private LocalDateTime updatedDate;
    @Column(name = "dateship")
    private LocalDateTime dateShip;
    @Column(name = "datepay")
    private LocalDateTime datePay;
    @Column(name = "ordervalue")
    private Double orderValue;
    @Column(name = "status")
    private StatusOrder statusOrder;
    @JoinColumn(name = "cartid")
    private Long cartId;
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderDetail> orderDetailList;
    @Column(name = "feeship")
    private Double feeShip;

}
