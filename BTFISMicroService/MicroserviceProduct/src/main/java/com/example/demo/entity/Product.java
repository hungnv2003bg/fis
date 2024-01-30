package com.example.demo.entity;


import com.example.demo.enums.StatusProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codeproduct")
    private String codeProduct;
    @Column(name = "nameproduct")
    private String nameProduct;
    @Column(name = "priceinput")
    private Double priceInput;
    @Column(name = "priceoutput")
    private Double priceOutput;
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "updatedate")
    private LocalDateTime updatedDate;
    @Column(name = "status")
    private StatusProduct statusProduct;
    @Column(name = "soluongton")
    private Integer soLuongTon;
    @Column(name = "soluongdaban")
    private Integer soLuongDaBan;
    @JoinColumn(name = "categoryid")
    @ManyToOne
    @JsonIgnore
    private Category category;

}
