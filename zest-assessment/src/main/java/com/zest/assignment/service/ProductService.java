package com.zest.assignment.service;


import com.zest.assignment.dto.ProductRequestDTO;
import com.zest.assignment.dto.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<ProductResponseDTO> getAllProducts(Pageable pageable);

    ProductResponseDTO getProductById(Integer id);

    ProductResponseDTO createProduct(ProductRequestDTO dto);

    ProductResponseDTO updateProduct(Integer id, ProductRequestDTO dto);

    void deleteProduct(Integer id);
}