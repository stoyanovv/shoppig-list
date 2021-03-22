package examprep.shoppinglist.repository;

import examprep.shoppinglist.model.entity.Product;
import examprep.shoppinglist.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String > {

    Optional<Product> findByName(String name);

    @Query("SELECT SUM(p.price) FROM Product as p")
    BigDecimal allProductsPrice();

    List<Product> findAllByCategory_Name(CategoryName categoryName);

}
