package com.nz.nbp_converter;

import com.nz.nbp_converter.entity.Product;
import com.nz.nbp_converter.repository.ProductRepository;
import com.nz.nbp_converter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService =productService;
    }
    Converter converter = new Converter();

    @GetMapping("/")
    public String getProducts(Model model){
        var products = productService.getProducts();
        model.addAttribute("products",products);
        return "products";
    }
    @GetMapping("/find")
    public String search(@RequestParam(value="name",required = false) String name,Model model)
    {
        List<Product> products = productService.getProductsByName(name);
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
        var plnPrice = converter.convertUsdToPln(usdPrice) * usdPrice;
        product.setPlnPrice(plnPrice);
        productService.addProduct(product);
        return "redirect:/";
    }



}
