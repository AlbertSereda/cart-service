package com.market.cart.jpa.repository;

import com.market.cart.jpa.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
