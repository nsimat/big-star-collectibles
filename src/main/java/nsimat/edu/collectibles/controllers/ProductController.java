package nsimat.edu.collectibles.controllers;

import nsimat.edu.collectibles.beans.Product;
import nsimat.edu.collectibles.dao.ProductRepository;
import nsimat.edu.collectibles.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.Executor;

@Controller
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    private final Executor asyncExecutor;

    public ProductController(ProductService productService, Executor asyncExecutor) {
        this.productService = productService;
        this.asyncExecutor = asyncExecutor;
    }

    @PostMapping("/search")
    public String search(@RequestParam("searchString") String keyword, Model model){

        var products = productService.searchProductsByName(keyword);
        model.addAttribute("products", products);
        model.addAttribute("searchedFor", keyword);

        return "search-results";
    }

    @GetMapping("/getAllProducts")
    public DeferredResult<String> getAllProducts(Model model){
        DeferredResult<String> deferredResult = new DeferredResult<>();
        asyncExecutor.execute(() -> {
            model.addAttribute("products", getProducts());
            deferredResult.setResult("product-list");
        });
        return deferredResult;
    }

    private Iterable<Product> getProducts() {

        logger.info("Getting all products as we are on the spring executor thread");
        try{
            Thread.sleep(6000);
        }catch(InterruptedException exception){
            throw new RuntimeException("Something happened during waiting for products!!!");
        }
        return productService.findAllProducts();
    }

    @GetMapping("/getProductDetails")
    public String getProductDetails(Model model, @RequestParam("id") String productId){
        model.addAttribute("product", productService.searchProductById(productId));
        return "product-details";
    }
}
