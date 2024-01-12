package com.example.demo.repo;

import com.example.demo.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User1, InternalError> {
}
