package com.victortimbo.course.services;

import com.victortimbo.course.entities.Category;
import com.victortimbo.course.entities.Product;
import com.victortimbo.course.repositories.CategoryRepository;
import com.victortimbo.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.get();
    }
}
