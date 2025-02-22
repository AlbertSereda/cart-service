CREATE TABLE cart
(
    id            BIGINT PRIMARY KEY,
    user_id       BIGINT       NOT NULL,
    name          VARCHAR(100) NOT NULL,
    creation_date TIMESTAMP    NOT NULL DEFAULT NOW(),
    update_date   TIMESTAMP    NOT NULL DEFAULT NOW(),
    is_archive    BOOLEAN      NOT NULL DEFAULT FALSE
);

COMMENT ON TABLE cart IS 'User cart information';
COMMENT ON COLUMN cart.id IS 'Unique identifier for the cart';
COMMENT ON COLUMN cart.user_id IS 'Identifier of the user who owns the cart';
COMMENT ON COLUMN cart.name IS 'Name of the cart';
COMMENT ON COLUMN cart.creation_date IS 'Date of creation';
COMMENT ON COLUMN cart.update_date IS 'Date of the last update';
COMMENT ON COLUMN cart.is_archive IS 'Archive status of the cart';

CREATE TABLE cart_product
(
    id         BIGINT PRIMARY KEY,
    cart_id    BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity   INT    NOT NULL DEFAULT 1,
    CONSTRAINT cart_id_fk FOREIGN KEY (cart_id) REFERENCES cart (id)
);

COMMENT ON TABLE cart_product IS 'Links products to carts';
COMMENT ON COLUMN cart_product.id IS 'Unique identifier for the cart-product link';
COMMENT ON COLUMN cart_product.cart_id IS 'Identifier of the cart';
COMMENT ON COLUMN cart_product.product_id IS 'Identifier of the product';
COMMENT ON COLUMN cart_product.quantity IS 'Quantity of the product in the cart';