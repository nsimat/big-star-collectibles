package nsimat.edu.collectibles.services;

import nsimat.edu.collectibles.beans.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findProductList(String keyword);
}
