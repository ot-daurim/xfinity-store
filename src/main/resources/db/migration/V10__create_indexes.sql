CREATE INDEX  idx_categories_active
    ON categories (active);

CREATE INDEX  idx_products_category_id
    ON products (category_id);

CREATE INDEX  idx_products_status
    ON products (status);

CREATE INDEX  idx_products_created_at
    ON products (created_at);

CREATE INDEX  idx_products_price
    ON products (price);

CREATE INDEX  idx_cart_items_cart_id
    ON cart_items (cart_id);

CREATE INDEX idx_cart_items_product_id
    ON cart_items (product_id);

CREATE INDEX  idx_orders_user_id
    ON orders (user_id);

CREATE INDEX  idx_orders_status
    ON orders (status);

CREATE INDEX  idx_orders_created_at
    ON orders (created_at);

CREATE INDEX  idx_order_items_order_id
    ON order_items (order_id);

CREATE INDEX  idx_order_items_product_id
    ON order_items (product_id);