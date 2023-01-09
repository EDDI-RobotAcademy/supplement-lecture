package com.example.boilerplateproj.domain.vue.product.repository;

import com.example.boilerplateproj.domain.product.entity.Product;
import com.example.boilerplateproj.domain.vue.product.entity.VueProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueProductRepository extends JpaRepository<VueProduct, Long> {
}