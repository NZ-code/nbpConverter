package com.nz.nbp_converter.repository;

import com.nz.nbp_converter.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select p from Product p where p.name LIKE CONCAT('%',:name,'%')")
    public List<Product> findAllByLikeName(@Param("name") String name);
}
