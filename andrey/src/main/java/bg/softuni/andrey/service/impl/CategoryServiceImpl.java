package bg.softuni.andrey.service.impl;

import bg.softuni.andrey.model.entity.Category;
import bg.softuni.andrey.model.entity.enums.CategoryNameEnum;
import bg.softuni.andrey.model.entity.service.CategoryServiceModel;
import bg.softuni.andrey.repository.CategoryRepository;
import bg.softuni.andrey.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategory() {

        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category = new Category(categoryNameEnum, "Description for "
                        + categoryNameEnum.name());

                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryServiceModel findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
       return categoryRepository.findByName(categoryNameEnum)
               .map(category -> modelMapper.map(category, CategoryServiceModel.class))
               .orElse(null);
    }
}
