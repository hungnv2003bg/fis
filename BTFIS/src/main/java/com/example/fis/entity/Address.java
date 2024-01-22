package com.example.fis.entity;

import com.example.fis.enums.StatusAddress;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "userid")
    @ManyToOne
    @JsonIgnore
    private User user;
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "wardid")
    private String wardId;
    @Column(name = "districtid")
    private String districtId;
    @Column(name = "provinceid")
    private String provinceId;
    @Column(name = "ward")
    private String ward;
    @Column(name = "district")
    private String district;
    @Column(name = "province")
    private String province;
    @Column(name = "addressdetail")
    private String addressDetail;
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "updatedate")
    private LocalDateTime updateDate;
    @Column(name = "phone")
    private String phone;
    @Column(name = "maindress")
    private Boolean mainDress;
    @Column(name = "status")
    private StatusAddress status;
    @OneToMany(mappedBy = "address")
    @JsonIgnore
    private List<Order> orderList;
}
