package bg.softuni.andrey.service;

import bg.softuni.andrey.model.entity.Category;
import bg.softuni.andrey.model.entity.enums.CategoryNameEnum;
import bg.softuni.andrey.model.entity.service.CategoryServiceModel;

public interface CategoryService {
    void initCategory();

    CategoryServiceModel findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
