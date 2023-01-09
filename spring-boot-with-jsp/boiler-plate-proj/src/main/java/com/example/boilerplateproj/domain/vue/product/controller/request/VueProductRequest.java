package com.example.boilerplateproj.domain.vue.product.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class VueProductRequest {

    private String name;
    private String price;
    private String description;
}
