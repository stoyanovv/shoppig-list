package examprep.shoppinglist.service.impl;

import examprep.shoppinglist.model.entity.Category;
import examprep.shoppinglist.model.entity.Product;
import examprep.shoppinglist.model.entity.enums.CategoryName;
import examprep.shoppinglist.model.service.ProductServiceModel;
import examprep.shoppinglist.model.view.ProductViewModel;
import examprep.shoppinglist.repository.ProductRepository;
import examprep.shoppinglist.service.CategoryService;
import examprep.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public ProductServiceModel findByProductName(String name) {
        return this.productRepository.findByName(name)
                .map(product -> modelMapper.map(product, ProductServiceModel.class))
                .orElse(null);

    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Category category = categoryService.findByName(productServiceModel.getCategoryName());
        Product product = modelMapper.map(productServiceModel, Product.class);
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {

        return productRepository.allProductsPrice();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategoryName(CategoryName categoryName) {
        return productRepository.findAllByCategory_Name(categoryName)
                .stream().map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyProduct(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
