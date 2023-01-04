package com.example.boilerplateproj.domain.product.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@ToString
@Table(name="product_test")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_product_seq_gen")
    @SequenceGenerator(sequenceName = "test_product_seq", name = "test_product_seq_gen", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private String name;
    private String description;
    private Long price;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    public Product(String name, String description, Long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
