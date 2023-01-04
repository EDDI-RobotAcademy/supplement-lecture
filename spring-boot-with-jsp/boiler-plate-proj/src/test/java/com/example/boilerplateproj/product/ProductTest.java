package com.example.boilerplateproj.product;

import com.example.boilerplateproj.domain.board.controller.request.BoardRequest;
import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.board.service.BoardService;
import com.example.boilerplateproj.domain.product.controller.request.ProductRequest;
import com.example.boilerplateproj.domain.product.entity.Product;
import com.example.boilerplateproj.domain.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductService service;

    private final long TARGET_PRODUCT_NUMBER = 1L;

    @Test
    public void writeTest () throws Exception {
        ProductRequest productRequest = new ProductRequest("상품명", "상품 세부 정보", 10000L);
        service.registerProduct(productRequest);
    }

    @Test
    public void findAllTest () throws Exception {
        List<Product> productLists = service.viewAllProduct();
        System.out.println(productLists);
    }

    @Test
    public void findByEntityMemberField () throws Exception {
        System.out.println(service.viewProduct(TARGET_PRODUCT_NUMBER));
    }

    @Test
    public void deleteByEntityMemberField () throws Exception {
        service.deleteProduct(TARGET_PRODUCT_NUMBER);
    }

    @Test
    public void modifyTest () throws Exception {
        ProductRequest productRequest = new ProductRequest("제목을 바꿔", "내용도 바꿔", 15000L);
        service.modifyProduct(productRequest, TARGET_PRODUCT_NUMBER);
    }
}
