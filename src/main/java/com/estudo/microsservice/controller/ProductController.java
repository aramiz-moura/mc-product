package com.estudo.microsservice.controller;


import com.estudo.microsservice.model.Product;
import com.estudo.microsservice.model.ProductRequest;
import com.estudo.microsservice.model.ProductResponse;
import com.estudo.microsservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{idProduct}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long idProduct) {
        Product product = productService.getProductById(idProduct);
        ProductResponse response = new ProductResponse(product);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }

    @PostMapping
    public ResponseEntity<ProductResponse> newProduct(@RequestBody ProductRequest productRequest) {
        Product product = productService.requestToEntity(productRequest);
        return new ResponseEntity<>(new ProductResponse(productService.saveProduct(product)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<ProductResponse> deleteById(@PathVariable Long idProduct) {
        return new ResponseEntity<>(productService.deleteProductById(idProduct),HttpStatus.ACCEPTED);
    }
    //TODO: PUT OR PATCH for changing existing product;
}
