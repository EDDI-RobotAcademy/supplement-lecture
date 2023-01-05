package com.example.boilerplateproj.domain.product.controller;

import com.example.boilerplateproj.domain.board.controller.request.BoardRequest;
import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.board.service.BoardService;
import com.example.boilerplateproj.domain.product.controller.request.ProductRequest;
import com.example.boilerplateproj.domain.product.entity.Product;
import com.example.boilerplateproj.domain.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/register")
    public void registerForm(Product product, Model model) throws Exception {
        log.info("registerForm");
    }

    @PostMapping("/register")
    public String register(ProductRequest productRequest, Model model) throws Exception {
        log.info("register");

        service.registerProduct(productRequest);

        model.addAttribute("msg", "등록이 완료되었습니다.");

        return "product/success";
    }

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        log.info("list");

        model.addAttribute("list", service.viewAllProduct());

        return "product/list";
    }

    @GetMapping("/read")
    public void read(int productId, Model model) throws Exception {
        log.info("read");

        model.addAttribute(service.viewProduct((long) productId));
    }

    @PostMapping("/remove")
    public String remove(int productId, Model model) throws Exception {
        log.info("remove");

        service.deleteProduct((long) productId);

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
