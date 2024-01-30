package com.example.demo.entity;

import com.example.demo.enums.StatusUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codeuser")
    private String codeUser;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "status")
    private StatusUser statusUser;
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "updatedate")
    private LocalDateTime updateDate;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Address> addressList;
    @JoinColumn(name = "roleid")
    @ManyToOne
    @JsonIgnore
    private Role role;

}
