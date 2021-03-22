package examprep.shoppinglist.service;

import examprep.shoppinglist.model.entity.Category;
import examprep.shoppinglist.model.entity.enums.CategoryName;

import java.util.Optional;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);
}
