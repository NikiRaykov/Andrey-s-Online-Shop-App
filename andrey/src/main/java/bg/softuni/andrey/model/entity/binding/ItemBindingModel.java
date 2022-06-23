package bg.softuni.andrey.model.entity.binding;

import bg.softuni.andrey.model.entity.enums.CategoryNameEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemBindingModel {

    public ItemBindingModel(){}

    @Length(min = 2, message = "Username must be more than two characters!")
    private String name;

    @Length(min = 2, message = "Description must be more than two characters!")
    private String description;

    @NotNull(message = "You must select the category.")
    private CategoryNameEnum category;

    private String gender;

    @DecimalMin(value = "0", message = "Price must be a positive number.")
    private BigDecimal price;

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

    public CategoryNameEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryNameEnum category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
