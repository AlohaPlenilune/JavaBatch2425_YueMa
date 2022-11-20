package com.plenilune.SpringBootPractice.service;

import com.plenilune.SpringBootPractice.entity.ProductItemEntity;
import com.plenilune.SpringBootPractice.vo.ProductItem;

import java.util.List;

public interface ProductItemService {

    ProductItem findById(long id);

    ProductItem saveProductItem(ProductItem productItem);

    ProductItem updateProductItem(ProductItem productItem);

    void deleteById(long id);

    List<ProductItem> findAllProductItems();
}
