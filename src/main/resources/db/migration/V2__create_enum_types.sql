CREATE TYPE user_role AS ENUM (
    'CUSTOMER',
    'ADMIN'
);

CREATE TYPE user_status AS ENUM (
    'ACTIVE',
    'BLOCKED',
    'DELETED'
);

CREATE TYPE product_status AS ENUM (
    'ACTIVE',
    'INACTIVE',
    'DELETED'
);

CREATE TYPE order_status AS ENUM (
    'CREATED',
    'PROCESSING',
    'COMPLETED',
    'CANCELLED'
);