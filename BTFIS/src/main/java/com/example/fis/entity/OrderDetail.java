package com.example.fis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orderdetail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "orderid")
    @ManyToOne
    @JsonIgnore
    private Order order;
    @JoinColumn(name = "productid")
    @ManyToOne
    private Product product;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "updatedate")
    private LocalDateTime updatedDate;
    @Column(name = "note")
    private String note;

}
