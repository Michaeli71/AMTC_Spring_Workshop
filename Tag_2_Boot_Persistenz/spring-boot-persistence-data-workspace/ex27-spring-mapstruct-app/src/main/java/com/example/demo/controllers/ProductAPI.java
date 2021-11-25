package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.services.ProductService;

/*
 * Test with curl

Create a new product

curl -i -H "Content-Type: application/json" -X POST -d '{"name":"Hello Koding","description": "Simple coding examples and tutorials","price":"1"}' http://localhost:8080/api/products

Find all products

curl -i http://localhost:8080/api/products

 */
@RestController
@RequestMapping("/api/products")
public class ProductAPI {
	private final ProductService productService;
	private final ProductMapper productMapper;

		
	public ProductAPI(ProductService productService, ProductMapper productMapper) {
		this.productService = productService;
		this.productMapper = productMapper;
	}

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> findAll() {
        List<Product> results = productService.findAll();
        return productMapper.toProductDTOs(results);
    }

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        Product entity = productMapper.toProduct(productDTO);
        productService.save(entity);

        return productDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Optional<Product> optProduct = productService.findById(id);

        if (optProduct.isEmpty())
            return ResponseEntity.notFound().build();
        ProductDTO dto = productMapper.toProductDTO(optProduct.get());
        return ResponseEntity.ok(dto);
    }

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
		Product product = productMapper.toProduct(productDTO);
		product.setId(id);

		productService.save(product);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		productService.deleteById(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}