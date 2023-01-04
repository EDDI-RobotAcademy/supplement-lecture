package com.example.boilerplateproj.domain.product.service;

import com.example.boilerplateproj.domain.product.controller.request.ProductRequest;
import com.example.boilerplateproj.domain.product.entity.Product;

import java.util.List;

public interface ProductService {

    // registerProduct -> 상품명, 상품 설명, 가격
    public void registerProduct (ProductRequest productRequest);
    // viewProduct
    public Product viewProduct (Long id);
    // modifyProduct
    public Product modifyProduct (ProductRequest productRequest, Long id);
    // deleteProduct
    public void deleteProduct (Long id);
    // viewAllProduct
    public List<Product> viewAllProduct ();
}
