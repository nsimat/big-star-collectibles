package nsimat.edu.collectibles.services;

import nsimat.edu.collectibles.beans.Product;
import nsimat.edu.collectibles.dao.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProductsByName(String keyword) {
        return productRepository.searchByName(keyword);
    }

    @Override
    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product searchProductById(String id) {
        return productRepository.searchById(id);
    }

    public Optional<Product> findProductById(int id){
        return productRepository.findById(Integer.valueOf(id));
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
