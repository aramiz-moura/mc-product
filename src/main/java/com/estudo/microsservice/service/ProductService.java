package com.estudo.microsservice.service;


import com.estudo.microsservice.model.Product;
import com.estudo.microsservice.model.ProductRequest;
import com.estudo.microsservice.model.ProductResponse;
import com.estudo.microsservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //TODO: will be an exception handler, if so create it
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductResponse deleteProductById(Long id) {
        Product product = getProductById(id);
        productRepository.deleteById(id);
        return new ProductResponse(product);
    }


    public Product requestToEntity(ProductRequest request) {
        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());

        return product;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


}
