CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    category_id BIGINT NOT NULL,

    name VARCHAR(255) NOT NULL,
    slug VARCHAR(180) NOT NULL,
    description TEXT NOT NULL,

    price NUMERIC(12, 2) NOT NULL,
    stock_quantity INTEGER NOT NULL DEFAULT 0,

    image_url VARCHAR(500),

    status product_status NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uk_products_slug UNIQUE (slug),

    CONSTRAINT fk_products_category
                      FOREIGN KEY (category_id)
                      REFERENCES categories (id)
                      ON DELETE RESTRICT,

    CONSTRAINT  chk_products_price_positive
        CHECK ( stock_quantity >= 0 ),

    CONSTRAINT  chk_products_stock_non_negative
                      CHECK ( stock_quantity >= 0 )

);