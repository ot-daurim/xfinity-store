package com.xfinity.store.features.catalog.category.controller;

import com.xfinity.store.features.catalog.category.dto.CategoryCreateRequest;
import com.xfinity.store.features.catalog.category.dto.CategoryResponse;
import com.xfinity.store.features.catalog.category.dto.CategoryUpdateRequest;
import com.xfinity.store.features.catalog.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryResponse> getActiveCategories() {
        return categoryService.getActiveCategories();
    }
    @GetMapping("/categories/{id}")
    public CategoryResponse getActiveCategory(
            @PathVariable Long id
    ) {
        return categoryService.getActiveCategoryById(id);
    }

    @PostMapping("/admin/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(
            @Valid
            @RequestBody
            CategoryCreateRequest request
    ) {
        return categoryService.createCategory(request);
    }

    @PutMapping("/admin/categories/{id}")
    public CategoryResponse updateCategory(
            @PathVariable Long id,
            @Valid
            @RequestBody
            CategoryUpdateRequest request
    ) {
        return categoryService.updateCategory(id, request);
    }

    @PatchMapping("/admin/categories/{id}/activate")
    public CategoryResponse activateCategory(
            @PathVariable Long id
    ){
        return categoryService.activateCategory(id);
    }
    @PatchMapping("/admin/categories/{id}/deactivate")
    public CategoryResponse deactivateCategory(
            @PathVariable Long id
    ) {
        return categoryService.deactivateCategory(id);
    }
}
