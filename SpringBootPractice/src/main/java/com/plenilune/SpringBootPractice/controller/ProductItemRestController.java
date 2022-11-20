package com.plenilune.SpringBootPractice.controller;


import com.plenilune.SpringBootPractice.exception.ProductItemException;
import com.plenilune.SpringBootPractice.exception.ProductItemNotFoundException;
import com.plenilune.SpringBootPractice.service.ProductItemService;
import com.plenilune.SpringBootPractice.vo.ErrorResponse;
import com.plenilune.SpringBootPractice.vo.ProductItem;
import com.plenilune.SpringBootPractice.vo.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductItemRestController {

    private static Logger logger = LoggerFactory.getLogger(ProductItemRestController.class);

    ProductItemService productItemService;

    @Autowired
    public ProductItemRestController(ProductItemService productItemService) {
        this.productItemService = productItemService;
    }

    /**
     * get single productItem by id
     * @param id
     * @return
     * @throws ProductItemException
     */
    @RequestMapping(value="/product/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> getProductItem(@PathVariable("id") long id) throws ProductItemException {
        ProductItem productItem = productItemService.findById(id);
        if (productItem == null) {
            throw new ProductItemNotFoundException("PRODUCT_NOT_FOUND");
        }
        return new ResponseEntity<ProductItem>(productItem, HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProductItems() {
        List<ProductItem> productItemList = productItemService.findAllProductItems();
        return new ResponseEntity<List<ProductItem>>(productItemList, HttpStatus.OK);
    }

    /**
     * create a productItem
     * @param productItem
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value="/product", method=RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<ResponseMessage> createProductItem(@Validated @RequestBody ProductItem productItem,
                                                             UriComponentsBuilder ucBuilder) {
        ProductItem savedProductItem = productItemService.saveProductItem(productItem);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/product/{id}").buildAndExpand(productItem.getId()).toUri());
        return new ResponseEntity<ResponseMessage>(
                new ResponseMessage("PRODUCT_CREATED", savedProductItem),
                headers,
                HttpStatus.CREATED
        );
    }

    /**
     * update a productItem
     * @param id
     * @param newProductItem
     * @return
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductItem> updateProductItem(@PathVariable("id") long id, @RequestBody ProductItem newProductItem) {

        ProductItem productItem = productItemService.findById(id);

        if (productItem == null) {
            throw new ProductItemNotFoundException("PRODUCT_NOT_FOUND");
        }

        productItem.setName(newProductItem.getName());
        productItem.setPrice(newProductItem.getPrice());
        productItem.setQuantity(newProductItem.getQuantity());

        productItemService.updateProductItem(productItem);
        return new ResponseEntity<ProductItem>(productItem, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseMessage> deleteProductItem(@PathVariable("id") long id) {

        ProductItem productItem = productItemService.findById(id);

        if (productItem == null) {
            throw new ProductItemNotFoundException("PRODUCT_NOT_FOUND");
        }

        productItemService.deleteById(id);
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("PRODUCT_DELETED", productItem), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage(ex.getMessage());
        logger.error("Controller Error", ex);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerProductItemNotFound(Exception ex) {
        logger.error("Cannot found product");
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }




}
