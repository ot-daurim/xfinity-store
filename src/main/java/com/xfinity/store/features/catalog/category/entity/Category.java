package com.xfinity.store.features.catalog.category.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_categories_slug",
                        columnNames = "slug"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            length = 120
    )
    private String name;

    @Column(
            name = "slug",
            nullable = false,
            length = 160,
            unique = true
    )
    private String slug;

    @Column(
            name = "description",
            length = 500
    )
    private String description;

    @Column(
            name = "active",
            nullable = false
    )
    private Boolean active = true;

    @CreationTimestamp
    @Column(
            name = "created_at",
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(
            name = "updated_at",
            nullable = false
    )
    private LocalDateTime updatedAt;

    public Category(String name, String slug, String description) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.active = true;
    }

    public void activate() {
        this.active = true;
    }
    public void deactivate() {
        this.active = false;
    }
}
