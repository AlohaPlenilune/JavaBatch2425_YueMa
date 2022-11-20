package com.plenilune.SpringBootPractice.service;

import com.plenilune.SpringBootPractice.dao.ProductItemRepository;
import com.plenilune.SpringBootPractice.entity.ProductItemEntity;
import com.plenilune.SpringBootPractice.util.ProductItemEntityConverter;
import com.plenilune.SpringBootPractice.vo.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service("productItemService")
public class ProductItemServiceImpl implements ProductItemService{

    @Autowired
    private ProductItemRepository productItemRepo;

    @Override
    public ProductItem findById(long id) {
        ProductItemEntity productItemEntity = productItemRepo.findById(id).orElse(null);
        return ProductItemEntityConverter.convertEntityToProductItem(productItemEntity);
    }

    @Override
    @Transactional
    public ProductItem saveProductItem(ProductItem productItem) {
        ProductItemEntity productItemEntity = productItemRepo.save(
                new ProductItemEntity(
                        productItem.getId(),
                        productItem.getName(),
                        productItem.getPrice(),
                        productItem.getQuantity()
                )
        );
        return ProductItemEntityConverter.convertEntityToProductItem(productItemEntity);
    }

    @Override
    public ProductItem updateProductItem(ProductItem productItem) {
        ProductItemEntity productItemEntity = productItemRepo.saveAndFlush(
                new ProductItemEntity(
                        productItem.getId(),
                        productItem.getName(),
                        productItem.getPrice(),
                        productItem.getQuantity()
                )
        );
        return ProductItemEntityConverter.convertEntityToProductItem(productItemEntity);
    }

    @Override
    public void deleteById(long id) {
        productItemRepo.deleteById(id);
    }

    @Override
    public List<ProductItem> findAllProductItems() {
        List<ProductItemEntity> productItemEntities = productItemRepo.findAll();
        return productItemEntities.stream().map(e ->
                        new ProductItem(e.getId(), e.getName(), e.getPrice(), e.getQuantity()))
                .collect(Collectors.toList());
    }
}
