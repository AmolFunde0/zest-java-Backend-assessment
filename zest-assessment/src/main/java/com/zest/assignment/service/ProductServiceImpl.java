package com.zest.assignment.service;

import com.zest.assignment.dto.ProductRequestDTO;
import com.zest.assignment.dto.ProductResponseDTO;
import com.zest.assignment.entity.Product;
import com.zest.assignment.exception.ResourceNotFoundException;
import com.zest.assignment.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<ProductResponseDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public ProductResponseDTO getProductById(Integer id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        return mapToResponse(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO dto) {

        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setCreatedBy("Admin");
        product.setCreatedOn(LocalDateTime.now());

        Product saved = productRepository.save(product);

        return mapToResponse(saved);
    }

    @Override
    public ProductResponseDTO updateProduct(Integer id, ProductRequestDTO dto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        product.setProductName(dto.getProductName());
        product.setModifiedBy("Admin");
        product.setModifiedOn(LocalDateTime.now());

        Product updated = productRepository.save(product);

        return mapToResponse(updated);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    // 🔹 Mapping Method
    private ProductResponseDTO mapToResponse(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getProductName(),
                product.getCreatedBy(),
                product.getCreatedOn()
        );
    }
}