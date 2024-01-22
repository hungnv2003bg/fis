package com.example.fis.repository;


import com.example.fis.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepo extends JpaRepository<Ship, Long> {
}
