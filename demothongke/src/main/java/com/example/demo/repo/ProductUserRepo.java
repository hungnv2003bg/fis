package com.example.demo.repo;

import com.example.demo.dto.ProductCoutDTO;
import com.example.demo.dto.UserCountDTO;
import com.example.demo.entity.ProductUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUserRepo extends JpaRepository<ProductUser, Integer> {

    @Query(value = "SELECT " +
            "  u.name AS name, " +
            "  COUNT(pu.productid) AS quantity " +
            "FROM " +
            "  product u " +
            "JOIN " +
            "  productuser pu ON u.id = pu.productid " +
            "GROUP BY " +
            "   u.name", nativeQuery = true)
    List<ProductCoutDTO>  findAllByProduct();

    @Query(value = "SELECT " +
            "  u.name AS name, " +
            "  COUNT(pu.userid) AS quantity " +
            "FROM " +
            "  user1 u " +
            "JOIN " +
            "  productuser pu ON u.id = pu.userid " +
            "GROUP BY " +
            "   u.name", nativeQuery = true)
    List<UserCountDTO>  findAllByUser();
}

