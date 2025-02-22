package com.market.cart.jpa.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "cart")
@Schema(description = "User cart information")
public class CartEntity {

    @Id
    @Column(name = "id")
    @Schema(description = "Unique identifier for the cart")
    private Long id;

    @Column(name = "user_id", nullable = false)
    @Schema(description = "Identifier of the user who owns the cart")
    private Long userId;

    @Column(name = "name", nullable = false, length = 100)
    @Schema(description = "Name of the cart")
    private String name;

    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreationTimestamp
    @Schema(description = "Date of creation")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "update_date", nullable = false)
    @UpdateTimestamp
    @Schema(description = "Date of the last update")
    private LocalDateTime updateDate = LocalDateTime.now();

    @Column(name = "is_archive", nullable = false)
    @Schema(description = "Archive status of the cart")
    private Boolean isArchive = false;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @Schema(description = "Products in the cart")
    private Set<CartProductEntity> cartProducts;
}
