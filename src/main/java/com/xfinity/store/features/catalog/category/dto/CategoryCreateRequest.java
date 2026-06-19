package com.xfinity.store.features.catalog.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryCreateRequest(
        @NotBlank(message = "Category name is required")
        @Size(max = 120, message = "Category description must be at most 120 characters")
        String name,

        @NotBlank(message = "Category slug is required")
        @Size(max = 160, message = "Category description must be at most 160 characters")
        String slug,

        @Size(max = 500, message = "Category description must be at most 500 characters")
        String description
) {
}
