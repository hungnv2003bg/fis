package com.example.fis.repository;


import com.example.fis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public boolean existsByEmailContains(String email);
//    public Optional<User> findUserByEmailEquals(String email);


}
