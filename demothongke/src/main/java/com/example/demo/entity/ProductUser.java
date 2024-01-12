package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productuser")
public class ProductUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "userid")
    User1 user1 = new User1();

    @ManyToOne
    @JoinColumn(name = "productid")
    Product product = new Product();

}
