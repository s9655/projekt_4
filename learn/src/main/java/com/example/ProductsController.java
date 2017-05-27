package com.example;

import com.example.model.Category;
import com.example.model.Product;
import com.example.persistence.ProductRepository;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public String index() {
        return "Hello world!";
    }

    @RequestMapping("/products")
    public List<Product> findAll() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @RequestMapping("/products/id")
    public Product findById(final Integer id) {
        return this.productRepository.findOne(id);
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public Product add(@RequestBody final Product body) {
        return this.productRepository.save(body);
    }

    @RequestMapping(value = "/products/update", method = RequestMethod.POST)
    public Product update(@RequestBody final Product body) {
        return this.productRepository.save(body);
    }

    @RequestMapping(value = "/products", params = {"from", "to"})
    public List<Product> findByPrice(
        @RequestParam("from") final BigDecimal from,
        @RequestParam("to") final BigDecimal to
    ) {
        return Lists.newArrayList(this.productRepository.findByPrice(from, to));
    }

    @RequestMapping(value = "/products", params = "name")
    public List<Product> findByName(
        @RequestParam("name") final String name
    ) {
        return Lists.newArrayList(this.productRepository.findByName(name));
    }

    @RequestMapping(value = "/products", params = "category")
    public List<Product> findByCategory(
        @RequestParam("category") final Category category
    ) {
        return Lists.newArrayList(
            this.productRepository.findByCategory(category)
        );
    }
}
