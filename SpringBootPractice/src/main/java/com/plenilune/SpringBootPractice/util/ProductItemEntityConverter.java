package com.plenilune.SpringBootPractice.util;

import com.plenilune.SpringBootPractice.entity.ProductItemEntity;
import com.plenilune.SpringBootPractice.vo.ProductItem;

public class ProductItemEntityConverter {

    public static ProductItem convertEntityToProductItem(ProductItemEntity productItemEntity) {
        if (productItemEntity != null) {
            ProductItem productItem = new ProductItem();
            productItem.setId(productItemEntity.getId());
            productItem.setName(productItemEntity.getName());
            productItem.setPrice(productItemEntity.getPrice());
            productItem.setQuantity(productItemEntity.getQuantity());
            return productItem;
        }
        return null;
    }
}
