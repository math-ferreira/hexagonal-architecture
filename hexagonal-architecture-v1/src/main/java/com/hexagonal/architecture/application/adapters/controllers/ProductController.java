package com.hexagonal.architecture.application.adapters.controllers;

import com.hexagonal.architecture.domain.dto.ProductDTO;
import com.hexagonal.architecture.domain.port.service.ProductServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @PostMapping
    @Operation(
            description = "Create a new Product",
            responses = @ApiResponse(responseCode = "200")
    )
    ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        productServicePort.createProduct(productDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(
            description = "Get the list of Products",
            responses = @ApiResponse(responseCode = "200")
    )
    ResponseEntity<List<ProductDTO>> getProducts() {
        var products = productServicePort.getProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping(value = "/{id}")
    @Operation(
            description = "Update a Product given a valid ID",
            responses = @ApiResponse(responseCode = "200")
    )
    ResponseEntity<?> updateProduct(
            @PathVariable(value = "id") UUID id,
            @RequestBody ProductDTO productDTO

    ) {
        productServicePort.updateProduct(id, productDTO);
        return ResponseEntity.ok().build();
    }

}
