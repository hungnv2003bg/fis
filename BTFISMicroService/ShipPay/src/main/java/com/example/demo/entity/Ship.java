package com.example.demo.entity;


import com.example.demo.enums.StatusShip;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "updatedate")
    private LocalDateTime updatedDate;
}
