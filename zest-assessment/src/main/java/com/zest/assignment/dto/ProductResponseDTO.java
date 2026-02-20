package com.zest.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
// This DTO is used to send product details in the response, including metadata like who created it and when.
public class ProductResponseDTO {

    private Integer id;
    private String productName;
    private String createdBy;
    private LocalDateTime createdOn;
}