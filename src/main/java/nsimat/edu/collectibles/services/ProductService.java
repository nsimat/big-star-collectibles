package nsimat.edu.collectibles.services;

import nsimat.edu.collectibles.beans.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> searchProductsByName(String keyword);

    Iterable<Product> findAllProducts();
    Product searchProductById(String id);
    Optional<Product> findProductById(int id);
    Product saveProduct(Product product);
    List<Product> searchProductsByCategory(int categoryId);
}
