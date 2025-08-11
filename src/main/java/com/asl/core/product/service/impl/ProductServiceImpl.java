package com.asl.core.product.service.impl;

import org.springframework.stereotype.Service;

import com.asl.core.product.entity.Product;
import com.asl.core.product.repository.ProductRepository;
import com.asl.core.product.service.ProductService;
import com.asl.core.product.util.ProductDTO;
import com.asl.core.product.util.ProductDTO.Create;
import com.asl.core.product.util.ProductDTO.Filters;
import com.asl.core.product.util.ProductDTO.Update;
import com.asl.core.product.util.ProductMapper;
import com.asl.core.shared.BaseServiceImpl;

@Service
public class ProductServiceImpl extends
        BaseServiceImpl<Product, Create, Update, ProductDTO, Filters>
        implements ProductService {

    public ProductServiceImpl(ProductRepository repository,
            ProductMapper mapper) {
        super(repository, mapper);

    }

}
