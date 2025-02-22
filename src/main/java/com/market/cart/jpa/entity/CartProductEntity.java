package com.market.cart.jpa.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cart_product")
@Schema(description = "Links products to carts")
public class CartProductEntity {

    @Id
    @Column(name = "id")
    @Schema(description = "Unique identifier for the cart-product link")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    @Schema(description = "Identifier of the cart")
    private CartEntity cart;

    @Column(name = "product_id", nullable = false)
    @Schema(description = "Identifier of the product")
    private Long productId;

    @Column(name = "quantity", nullable = false)
    @Schema(description = "Quantity of the product in the cart")
    private Integer quantity = 1;
}
