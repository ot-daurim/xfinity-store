package com.xfinity.store.features.catalog.category.repository;

import com.xfinity.store.features.catalog.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByActiveTrueOrderByNameAsc();
    Optional<Category> findByIdAndActiveTrue(Long id);

    boolean existsBySlug(String slug);

    boolean existsBySlugAndIdNot(String slug, Long id);
}
