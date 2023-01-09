package com.example.boilerplateproj.domain.vue.product.service;

import com.example.boilerplateproj.domain.product.controller.request.ProductRequest;
import com.example.boilerplateproj.domain.vue.product.controller.request.VueProductRequest;
import com.example.boilerplateproj.domain.vue.product.entity.VueProduct;
import com.example.boilerplateproj.domain.vue.product.repository.VueProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueProductServiceImpl implements VueProductService {

    @Autowired
    private VueProductRepository repository;

    @Override
    public void registerProduct(VueProductRequest productRequest) {
        VueProduct product = new VueProduct(
                productRequest.getName(),
                productRequest.getDescription(),
                Long.parseLong(productRequest.getPrice())
        );

        repository.save(product);
    }

    @Override
    public VueProduct viewProduct(Long id) {
        Optional<VueProduct> maybeProduct = repository.findById(id);

        if (maybeProduct.equals(Optional.empty())) {
            return null;
        }

        return maybeProduct.get();
    }

    @Override
    public VueProduct modifyProduct(VueProductRequest productRequest, Long id) {
        Optional<VueProduct> maybeProduct = repository.findById(id);

        if (maybeProduct.equals(Optional.empty())) {
            return null;
        }

        VueProduct findedProduct = maybeProduct.get();
        findedProduct.setName(productRequest.getName());
        findedProduct.setDescription(productRequest.getDescription());
        findedProduct.setPrice(Long.parseLong(productRequest.getPrice()));

        repository.save(findedProduct);

        return findedProduct;
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<VueProduct> viewAllProduct() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
