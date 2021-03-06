/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.translate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.translate.entity.Product;
import com.translate.repository.ProductRepository;
import com.translate.service.ProductService;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	public Product saveProduct(Product p) {

		return productRepository.save(p);
	}

}
