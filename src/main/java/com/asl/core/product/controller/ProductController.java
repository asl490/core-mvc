package com.asl.core.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asl.core.product.service.ProductService;
import com.asl.core.product.util.ProductDTO;
import com.asl.core.shared.BaseController;

@RestController
@RequestMapping("/products")
public class ProductController
        extends BaseController<ProductDTO.Create, ProductDTO.Update, ProductDTO, ProductDTO.Filters> {

    public ProductController(ProductService service) {
        super(service);
    }

}
