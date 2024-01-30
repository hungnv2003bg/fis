package com.example.demo.repo;

import com.example.demo.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepo extends JpaRepository<Pay, Long> {
}
