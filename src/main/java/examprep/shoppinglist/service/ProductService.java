package examprep.shoppinglist.service;

import examprep.shoppinglist.model.entity.enums.CategoryName;
import examprep.shoppinglist.model.service.ProductServiceModel;
import examprep.shoppinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductServiceModel findByProductName(String name);

    void addProduct(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName);

    void buyProduct(String id);

    void buyAll();
}
