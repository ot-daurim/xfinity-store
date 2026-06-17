CREATE TABLE cart_items (
    id BIGSERIAL PRIMARY KEY,

    cart_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,

    quantity INTEGER NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT  fk_cart_items_cart
                        FOREIGN KEY (product_id)
                        REFERENCES carts (id)
                        ON DELETE CASCADE,

    CONSTRAINT fk_cart_items_product
                        FOREIGN KEY (product_id)
                        REFERENCES  products (id)
                        ON DELETE RESTRICT,

    CONSTRAINT uk_cart_items_cart_product
                        UNIQUE (cart_id, product_id),

    CONSTRAINT chk_cart_items_quantity_positive
                        CHECK ( quantity > 0 )

);