package com.example.boilerplateproj.domain.product.service;

import com.example.boilerplateproj.domain.product.controller.request.ProductRequest;
import com.example.boilerplateproj.domain.product.entity.Product;
import com.example.boilerplateproj.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void registerProduct(Product productRequest) {
        Product product = new Product(
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getPrice()
        );

        repository.save(product);
    }

    @Override
    public Product viewProduct(Long id) {
        Optional<Product> maybeProduct = repository.findById(id);

        if (maybeProduct.equals(Optional.empty())) {
            return null;
        }

        return maybeProduct.get();
    }

    @Override
    public Product modifyProduct(ProductRequest productRequest, Long id) {
        Optional<Product> maybeProduct = repository.findById(id);

        if (maybeProduct.equals(Optional.empty())) {
            return null;
        }

        Product findedProduct = maybeProduct.get();
        findedProduct.setName(productRequest.getName());
        findedProduct.setDescription(productRequest.getDescription());
        findedProduct.setPrice(productRequest.getPrice());

        repository.save(findedProduct);

        return findedProduct;
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> viewAllProduct() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
