package com.example.fis.repository;


import com.example.fis.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepo extends JpaRepository<Pay, Long> {
}
