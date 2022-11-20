package com.plenilune.SpringBootPractice.dao;

import com.plenilune.SpringBootPractice.entity.ProductItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItemEntity, Long> {
    ProductItemEntity findByPriceBetween(double from, double to);
}
