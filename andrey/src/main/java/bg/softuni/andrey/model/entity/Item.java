package bg.softuni.andrey.model.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    public Item() {
    }

    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @DecimalMin(value = "0")
    private BigDecimal price;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    @ManyToOne
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
