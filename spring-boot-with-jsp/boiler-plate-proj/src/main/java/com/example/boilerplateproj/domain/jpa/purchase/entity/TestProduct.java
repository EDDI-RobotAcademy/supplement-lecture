package com.example.boilerplateproj.domain.jpa.purchase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class TestProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_product_seq_gen")
    @SequenceGenerator(sequenceName = "test_product_seq", name = "test_product_seq_gen", allocationSize = 1)
    @Column(name = "id")
    private Long productId;

    private String name;
    private Long price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public TestProduct (String name, Long price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void setBasket (Basket basket) {
        this.basket = basket;
    }
}
