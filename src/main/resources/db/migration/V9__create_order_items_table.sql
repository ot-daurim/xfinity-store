CREATE TABLE order_items (
    id BIGSERIAL PRIMARY KEY,

    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,

    product_name VARCHAR(255) NOT NULL,

    price_at_purchase NUMERIC(12, 2) NOT NULL,
    quantity INTEGER NOT NULL,
    total_price NUMERIC(12, 2) NOT NULL,

    CONSTRAINT fk_order_items_order
                         FOREIGN KEY (order_id)
                         REFERENCES orders (id)
                         ON DELETE CASCADE,

    CONSTRAINT fk_order_items_product
                         FOREIGN KEY (product_id)
                         REFERENCES products (id)
                         ON DELETE RESTRICT,

    CONSTRAINT chk_order_items_price_positive
                         CHECK ( price_at_purchase > 0),

    CONSTRAINT chk_order_items_quantity_positive
                         CHECK ( quantity > 0 ),

    CONSTRAINT chk_order_items_total_price_positive
                         CHECK ( total_price > 0 ),

    CONSTRAINT chk_order_items_total_price_calculated
                         CHECK ( total_price = price_at_purchase * quantity )
);