package com.example.boilerplateproj.domain.jpa.purchase.repository;

import com.example.boilerplateproj.domain.jpa.lecture.entity.Student;
import com.example.boilerplateproj.domain.jpa.purchase.entity.TestProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestProductRepository extends JpaRepository<TestProduct, Long> {

    @Query("select tp from TestProduct tp join tp.basket b where b.basketName = :name")
    List<TestProduct> findProductListByBasketName (String name);
}
