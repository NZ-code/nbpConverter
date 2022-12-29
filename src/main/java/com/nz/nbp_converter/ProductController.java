package com.nz.nbp_converter;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    Converter converter = new Converter();
    List<Product> products = new ArrayList<>();
    @GetMapping("/")
    public String getProducts(Model model){
        model.addAttribute("products",products);
        return "products";
    }
    @GetMapping("/submit")
    public String getSubmitPage(Model model){
        model.addAttribute("product",new Product());
        return "submit-product";
    }
    @PostMapping("/submitProduct")
    public String submitProduct(Product product){
        var usdPrice = product.getUsdPrice();
        var plnPrice = converter.convertUsdToPln(usdPrice);
        product.setPlnPrice(plnPrice);
        products.add(product);
        return "redirect:/";
    }
}
