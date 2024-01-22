package com.example.fis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "customerid")
    @ManyToOne
    @JsonIgnore
    private User customer;
    @JoinColumn(name = "productid")
    @ManyToOne
    @JsonIgnore
    private Product product;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "updatedate")
    private LocalDateTime updateDate;
}
