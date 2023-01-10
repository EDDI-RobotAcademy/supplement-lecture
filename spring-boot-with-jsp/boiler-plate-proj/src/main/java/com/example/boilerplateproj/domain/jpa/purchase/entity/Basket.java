package com.example.boilerplateproj.domain.jpa.purchase.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basket_seq_gen")
    @SequenceGenerator(sequenceName = "basket_seq", name = "basket_seq_gen", allocationSize = 1)
    @Column(name = "id")
    private Long basketId;

    private String basketName;

    public Basket (String basketName) {
        this.basketName = basketName;
    }
}
