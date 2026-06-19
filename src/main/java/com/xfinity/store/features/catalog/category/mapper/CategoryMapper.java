package com.xfinity.store.features.catalog.category.mapper;

import com.xfinity.store.features.catalog.category.dto.CategoryResponse;
import com.xfinity.store.features.catalog.category.entity.Category;

public class CategoryMapper {

    private CategoryMapper() {}

    public static CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getSlug(),
                category.getDescription(),
                category.getActive(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }
}
