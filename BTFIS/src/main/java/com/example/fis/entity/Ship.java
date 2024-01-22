package com.example.fis.entity;

import com.example.fis.enums.StatusShip;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ship")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codeship")
    private String codeShip;
    @Column(name = "nameship")
    private String nameShip;
    @Column(name = "status")
    private StatusShip statusShip;
    @OneToMany(mappedBy = "ship")
    @JsonIgnore
    private List<Order> orderList;
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "updatedate")
    private LocalDateTime updatedDate;
}
