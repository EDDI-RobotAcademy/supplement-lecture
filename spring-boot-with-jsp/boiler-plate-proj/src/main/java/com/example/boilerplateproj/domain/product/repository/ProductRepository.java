package com.example.boilerplateproj.domain.product.repository;

import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}