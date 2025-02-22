package com.market.cart.jpa.repository;

import com.market.cart.jpa.entity.CartProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProductEntity, Long> {

}
