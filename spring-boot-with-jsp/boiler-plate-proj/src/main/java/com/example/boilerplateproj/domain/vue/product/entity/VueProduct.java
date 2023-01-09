package com.example.boilerplateproj.domain.vue.product.entity;

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
@Table(name="vue_product")
@NoArgsConstructor
public class VueProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vue_product_seq_gen")
    @SequenceGenerator(sequenceName = "vue_product_seq", name = "vue_product_seq_gen", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private String name;
    private String description;
    private Long price;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    public VueProduct(String name, String description, Long price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
