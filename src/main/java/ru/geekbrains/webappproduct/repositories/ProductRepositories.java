package ru.geekbrains.webappproduct.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.webappproduct.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepositories {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        this.productList = new ArrayList<>();
        productList.add(new Product(1, "Кроссовки", 50.3));
        productList.add(new Product(2, "Сапоги", 150.2));
        productList.add(new Product(3, "Ботинки", 48.1));
        productList.add(new Product(4, "Туфли", 36.8));
        productList.add(new Product(5, "Кеды", 29.5));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getById(int id) {
        return productList.stream().filter(product -> product.getId() == id)
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }
}
