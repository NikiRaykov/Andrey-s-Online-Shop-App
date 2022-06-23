package bg.softuni.andrey.model.entity.service;

import bg.softuni.andrey.model.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;

public class ItemServiceModel {

    public ItemServiceModel() {
    }

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String gender;
    private CategoryServiceModel category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public void setCategory(CategoryServiceModel category) {
        this.category = category;
    }
}
