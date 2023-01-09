package com.example.boilerplateproj.domain.vue.product.controller;

import com.example.boilerplateproj.domain.product.controller.request.ProductRequest;
import com.example.boilerplateproj.domain.product.entity.Product;
import com.example.boilerplateproj.domain.product.service.ProductService;
import com.example.boilerplateproj.domain.vue.board.entity.VueBoard;
import com.example.boilerplateproj.domain.vue.product.controller.request.VueProductRequest;
import com.example.boilerplateproj.domain.vue.product.entity.VueProduct;
import com.example.boilerplateproj.domain.vue.product.service.VueProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vue-product")
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
public class VueProductController {

    @Autowired
    private VueProductService service;

    @PostMapping("/register")
    public void register(@RequestBody VueProductRequest productRequest) throws Exception {
        log.info("register: " + productRequest);

        service.registerProduct(productRequest);
    }

    @GetMapping("/list")
    public List<VueProduct> list() throws Exception {
        log.info("list");

        return service.viewAllProduct();
    }

    @GetMapping("/{id}")
    public VueProduct read(@PathVariable("id") int id) throws Exception {
        log.info("read");

        return service.viewProduct((long) id);
    }

    @PostMapping("/remove")
    public String remove(int id, Model model) throws Exception {
        log.info("remove");

        service.deleteProduct((long) id);

        model.addAttribute("msg", "삭제가 완료되었습니다.");

        return "product/success";
    }

    @PutMapping("/{id}")
    public void modifyForm(@PathVariable("id") int id,
                           @RequestBody VueProductRequest productRequest) throws Exception {
        log.info("modifyForm: " + id);

        service.modifyProduct(productRequest, (long) id);
    }
}
