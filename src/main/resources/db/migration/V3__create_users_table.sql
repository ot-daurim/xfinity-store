CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,

    email VARCHAR(100) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,

    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    phone VARCHAR(30),

    role user_role NOT NULL DEFAULT 'CUSTOMER',
    staus user_status NOT NULL DEFAULT 'ACTIVE',

    last_login TIMESTAMP,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uk_users_email UNIQUE (email)
);