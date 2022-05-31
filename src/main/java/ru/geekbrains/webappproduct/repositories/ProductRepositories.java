package ru.geekbrains.webappproduct.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.webappproduct.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepositories {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        this.productList = new ArrayList<>();
        productList.add(new Product(1L, "Кроссовки", 50));
        productList.add(new Product(2L, "Сапоги", 150));
        productList.add(new Product(3L, "Ботинки", 48));
        productList.add(new Product(4L, "Туфли", 36));
        productList.add(new Product(5L, "Кеды", 29));
    }

    public List<Product> getProductList() {

        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getById(Long id) {
        return productList.stream().filter(product -> product.getId().equals(id))
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }
}
