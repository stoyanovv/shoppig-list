package examprep.shoppinglist.service.impl;

import examprep.shoppinglist.model.entity.Category;
import examprep.shoppinglist.model.entity.enums.CategoryName;
import examprep.shoppinglist.repository.CategoryRepository;
import examprep.shoppinglist.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category(categoryName,
                            "Description for " + categoryName.name());
            this.categoryRepository.save(category);
        });
        }
    }

    @Override
    public Category findByName(CategoryName categoryName) {
        return categoryRepository.findByName(categoryName)
                .orElse(null);
    }
}
