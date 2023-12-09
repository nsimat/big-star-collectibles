package nsimat.edu.collectibles.controllers;

import nsimat.edu.collectibles.beans.Product;
import nsimat.edu.collectibles.dao.ProductRepository;
import nsimat.edu.collectibles.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/search")
    public String search(@RequestParam("searchString") String keyword, Model model){

        var products = productService.findProductList(keyword);
        model.addAttribute("products", products);
        model.addAttribute("searchedFor", keyword);

        return "search-results";
    }
}
