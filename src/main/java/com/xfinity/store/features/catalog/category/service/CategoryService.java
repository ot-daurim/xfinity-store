package com.xfinity.store.features.catalog.category.service;


import com.xfinity.store.features.catalog.category.dto.CategoryCreateRequest;
import com.xfinity.store.features.catalog.category.dto.CategoryResponse;
import com.xfinity.store.features.catalog.category.dto.CategoryUpdateRequest;
import com.xfinity.store.features.catalog.category.entity.Category;
import com.xfinity.store.features.catalog.category.mapper.CategoryMapper;
import com.xfinity.store.features.catalog.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryResponse> getActiveCategories() {
        return categoryRepository.findAllByActiveTrueOrderByNameAsc()
                .stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public CategoryResponse getActiveCategoryById(Long id) {
        Category category = categoryRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id " + id + " not found."
                ));
        return CategoryMapper.toResponse(category);
    }

    @Transactional
    public CategoryResponse createCategory(CategoryCreateRequest request) {
        validateSlugIsUnique(request.slug());
        Category category = new Category(
                request.name(),
                request.slug(),
                request.description()
        );

        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.toResponse(savedCategory);
    }

    @Transactional
    public CategoryResponse updateCategory(Long id, CategoryUpdateRequest request) {
        Category category = findCategoryById(id);

        if (request.slug() != null) {
            validateSlugIsUniqueForUpdate(request.slug(), id);
            category.setSlug(request.slug());
        }

        if(request.name() != null) {
            category.setName(request.name());
        }

        if(request.description() != null) {
            category.setDescription(request.description());
        }

        if(request.active() != null) {
            category.setActive(request.active());
        }
        return CategoryMapper.toResponse(category);
    }

    @Transactional
    public CategoryResponse activateCategory(Long id) {
        Category category = findCategoryById(id);
        category.activate();

        return CategoryMapper.toResponse(category);
    }

    @Transactional
    public CategoryResponse deactivateCategory(Long id) {
        Category category = findCategoryById(id);
        category.deactivate();

        return CategoryMapper.toResponse(category);
    }

    private Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category with id " + id + " not found."
                ));
    }

    private void validateSlugIsUnique(String slug) {
        if (categoryRepository.existsBySlug(slug)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Slug " + slug + " already exists."
            );
        }
    }
    private void validateSlugIsUniqueForUpdate(String slug, Long categoryId) {
        if (categoryRepository.existsBySlugAndIdNot(slug, categoryId)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Category with slug '" + slug + "' already exists"
            );
        }
    }

}
