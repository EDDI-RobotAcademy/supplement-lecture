package com.example.boilerplateproj.domain.jpa.purchase.repository;

import com.example.boilerplateproj.domain.jpa.purchase.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
