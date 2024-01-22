package com.example.fis.entity;

import com.example.fis.enums.StatusOrder;
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
    @JoinColumn(name = "customerid")
    @ManyToOne
    @JsonIgnore
    private User customer;
    @JoinColumn(name = "addressid")
    @ManyToOne
    @JsonIgnore
    private Address address;
    @Column(name = "codeorder")
    private String codeOrder;
    @JoinColumn(name = "pay")
    @ManyToOne
    @JsonIgnore
    private Pay pay;
    @JoinColumn(name = "ship")
    @ManyToOne
    @JsonIgnore
    private Ship ship;
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
    @JoinColumn(name = "employeeid")
    @ManyToOne
    @JsonIgnore
    private User employee;
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderDetail> orderDetailList;
    @Column(name = "feeship")
    private Double feeShip;

}
