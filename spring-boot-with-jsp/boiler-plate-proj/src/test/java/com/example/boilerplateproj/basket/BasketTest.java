package com.example.boilerplateproj.basket;

import com.example.boilerplateproj.domain.jpa.purchase.entity.Basket;
import com.example.boilerplateproj.domain.jpa.purchase.entity.TestProduct;
import com.example.boilerplateproj.domain.jpa.purchase.repository.BasketRepository;
import com.example.boilerplateproj.domain.jpa.purchase.repository.TestProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class BasketTest {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private TestProductRepository productRepository;

    @Test
    void insertNewProductTest () {
        Basket basket = new Basket("첫번째 바구니");
        basketRepository.save(basket);

        for (int i = 1; i < 11; i++) {
            TestProduct testProduct = new TestProduct("상품" + i, 10000L, "상세 설명" + i);
            testProduct.setBasket(basket);
            productRepository.save(testProduct);
        }
    }

    @Test
    void insertNewProductTest2 () {
        Basket basket = new Basket("두번째 바구니");
        basketRepository.save(basket);

        for (int i = 1; i < 6; i++) {
            TestProduct testProduct = new TestProduct("다른상품" + i, 10000L, "또 다른 상세 설명" + i);
            testProduct.setBasket(basket);
            productRepository.save(testProduct);
        }
    }

    @Test
    void searchEveryProduct () {
        System.out.println(productRepository.findAll());
    }

    @Test
    void findProductListWithBasketName () {
        System.out.println(productRepository.findProductListByBasketName("두번째 바구니"));
    }

    @Test
    void modifyProduct () {
        Optional<TestProduct> maybeProduct = productRepository.findById(5L);

        if (maybeProduct.isEmpty()) {
            System.out.println("찾는 정보가 없습니다!");
            return;
        }

        TestProduct testProduct = maybeProduct.get();

        Basket basket = new Basket("새로운 바구니");
        basketRepository.save(basket);

        testProduct.setBasket(basket);
        productRepository.save(testProduct);
    }
}
