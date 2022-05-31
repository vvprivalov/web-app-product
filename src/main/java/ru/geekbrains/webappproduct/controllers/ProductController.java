package ru.geekbrains.webappproduct.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.webappproduct.model.Product;
import ru.geekbrains.webappproduct.services.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET http://localhost:8189/app
    @GetMapping(value = "/")
    public String showAllProducts(Model model){
        model.addAttribute("products", productService.getListProduct());
        return "products";
    }

    @GetMapping(value = "/inc/{id}")
    public String incPrice(Model model, @PathVariable Long id) {
        productService.changePrice(id, 1);
        model.addAttribute("products", productService.getListProduct());
        return "redirect:/";
    }

    @GetMapping(value = "/dec/{id}")
    public String decPrice(Model model, @PathVariable Long id) {
        productService.changePrice(id, -1);
        model.addAttribute("products", productService.getListProduct());
        return "redirect:/";
    }

    // GET http://localhost:8189/app/show/{id}
    @GetMapping(value = "/show/{id}")
    public String showStudentPageById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProductById(id));
        return "product_info";
    }

    // GET http://localhost:8189/app/create
    @GetMapping(value = "/create")
    public String createProduct(){

        return "create_product";
    }

    // POST http://localhost:8189/app/create
    @PostMapping(value = "/create")
    public String addProduct(@RequestParam Long id, @RequestParam String name, @RequestParam int price){
        productService.addProduct(new Product(id, name, price));
        return "redirect:/";
    }
}
