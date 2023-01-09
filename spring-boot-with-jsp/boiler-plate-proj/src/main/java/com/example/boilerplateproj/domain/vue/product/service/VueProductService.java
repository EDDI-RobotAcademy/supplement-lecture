package com.example.boilerplateproj.domain.vue.product.service;

import com.example.boilerplateproj.domain.product.controller.request.ProductRequest;
import com.example.boilerplateproj.domain.product.entity.Product;
import com.example.boilerplateproj.domain.vue.product.entity.VueProduct;

import java.util.List;

public interface VueProductService {

    // registerProduct -> 상품명, 상품 설명, 가격
    public void registerProduct (VueProduct product);
    // viewProduct
    public VueProduct viewProduct (Long id);
    // modifyProduct (보류)
    public VueProduct modifyProduct (ProductRequest productRequest, Long id);
    // deleteProduct
    public void deleteProduct (Long id);
    // viewAllProduct
    public List<VueProduct> viewAllProduct ();
}
