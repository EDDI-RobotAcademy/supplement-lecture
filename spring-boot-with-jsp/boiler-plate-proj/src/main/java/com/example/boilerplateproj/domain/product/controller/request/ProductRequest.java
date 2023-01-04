package com.example.boilerplateproj.domain.product.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductRequest {

    private String name;
    private String description;
    private Long price;
}
