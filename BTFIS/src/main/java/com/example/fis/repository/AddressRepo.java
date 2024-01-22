package com.example.fis.repository;

import com.example.fis.entity.Address;
import com.example.fis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Long> {
    public List<Address> findAddresssByUser(User user);
}
