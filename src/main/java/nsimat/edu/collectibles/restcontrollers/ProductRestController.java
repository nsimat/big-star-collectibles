package nsimat.edu.collectibles.restcontrollers;

import nsimat.edu.collectibles.beans.Product;
import nsimat.edu.collectibles.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/bigstar/api/products")
    public List<Product> allProducts(){
        return (List<Product>) productService.findAllProducts();
    }

    @GetMapping("/bigstar/api/products/{id}")
    public Product getProductbyId(@PathVariable("id") String id){
        return productService.findProductById(Integer.valueOf(id)).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping("/bigstar/api/products")
    public Product saveProduct(@RequestBody Product newProduct){
        return productService.findProductById(newProduct.getId()).map(product -> {
            product.setName(newProduct.getName());
            product.setCategoryId(newProduct.getCategoryId());
            product.setRobotId(newProduct.getRobotId());
            product.setColor(newProduct.getColor());
            product.setImagePath(newProduct.getImagePath());
            product.setRating(newProduct.getRating());
            product.setNoOfReviews(newProduct.getNoOfReviews());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return productService.saveProduct(newProduct);
        }).orElseGet(() -> productService.saveProduct(newProduct));
    }
}
