CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    order_number VARCHAR(40) NOT NULL,

    status order_status NOT NULL DEFAULT 'CREATED',

    total_amount NUMERIC(12, 2) NOT NULL DEFAULT 0,

    customer_name VARCHAR(150) NOT NULL,
    customer_phone VARCHAR(30) NOT NULL,
    delivery_address VARCHAR(500) NOT NULL,

    comment VARCHAR(1000),

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uk_orders_order_number UNIQUE (order_number),

    CONSTRAINT fk_orders_user
                    FOREIGN KEY (user_id)
                    REFERENCES users (id)
                    ON DELETE RESTRICT,

    CONSTRAINT chk_orders_total_amount_non_negative
                    CHECK ( total_amount >= 0 )
)