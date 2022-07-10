package com.estudo.microsservice.controller;


import com.estudo.microsservice.model.Product;
import com.estudo.microsservice.model.ProductResponse;
import com.estudo.microsservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{idProdcut}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long idProduct) {
        Product product = productService.getProductById(idProduct);
        ProductResponse response = new ProductResponse(product);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }

    //TODO: POST for new Product
    //TODO: PUT OR PATCH for changing existing product;
}
