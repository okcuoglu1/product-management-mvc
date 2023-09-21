package com.enoca.repository;

import com.enoca.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    boolean existsByName(String name);

    List<Product> findByIdEquals(Integer id);
}
