package nsimat.edu.collectibles.dao;

import nsimat.edu.collectibles.beans.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("select p from Product p where p.name like %:searchString%")
    List<Product> searchByName(@Param("searchString") String keyword);

    @Override
    Iterable<Product> findAll();

    @Query("select p from Product p where p.id = :id")
    public Product searchById (@Param("id") String keyword);

    @Query("select p from Product p where p.categoryId = :id")
    List<Product> searchByCategoryId(@Param("id") Integer keyword);
}
