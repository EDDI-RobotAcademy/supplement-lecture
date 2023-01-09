package com.example.boilerplateproj.domain.vue.product.controller;

import com.example.boilerplateproj.domain.product.controller.request.ProductRequest;
import com.example.boilerplateproj.domain.product.entity.Product;
import com.example.boilerplateproj.domain.product.service.ProductService;
import com.example.boilerplateproj.domain.vue.product.entity.VueProduct;
import com.example.boilerplateproj.domain.vue.product.service.VueProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vue-product")
public class VueProductController {

    @Autowired
    private VueProductService service;

    @PostMapping("/register")
    public String register(VueProduct product, Model model) throws Exception {
        log.info("register");

        service.registerProduct(product);

        model.addAttribute("msg", "등록이 완료되었습니다.");

        return "product/success";
    }

    @GetMapping("/list")
    public List<VueProduct> list() throws Exception {
        log.info("list");

        return service.viewAllProduct();
    }

    @GetMapping("/read")
    public void read(int productId, Model model) throws Exception {
        log.info("read");

        model.addAttribute(service.viewProduct((long) productId));
    }

    @PostMapping("/remove")
    public String remove(int id, Model model) throws Exception {
        log.info("remove");

        service.deleteProduct((long) id);

        model.addAttribute("msg", "삭제가 완료되었습니다.");

        return "product/success";
    }

    @GetMapping("/modify")
    public void modifyForm(int productId, Model model) throws Exception {
        log.info("modifyForm: " + productId);

        model.addAttribute(service.viewProduct((long) productId));
    }

    @PostMapping("/modify")
    public String modify(ProductRequest productRequest, Model model) throws Exception {
        log.info("modify: " + productRequest);

        service.modifyProduct(productRequest, (long) Math.toIntExact(productRequest.getId()));

        model.addAttribute("msg", "수정이 완료되었습니다.");

        return "product/success";
    }

}
