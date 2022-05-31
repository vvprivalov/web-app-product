package ru.geekbrains.webappproduct.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.webappproduct.model.Product;
import ru.geekbrains.webappproduct.repositories.ProductRepositories;

import java.util.List;

@Service
public class ProductService {
    private ProductRepositories productRepositories;

    @Autowired
    public ProductService(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    public List<Product> getListProduct() {
        return productRepositories.getProductList();
    }

    public void addProduct(Product product) {
        productRepositories.addProduct(product);
    }

    public Product getProductById(Long id) {
        return productRepositories.getById(id);
    }

    public void changePrice(long id, int price) {
        Product product= productRepositories.getById(id);
        product.setPrice(product.getPrice() + price);
    }
}
