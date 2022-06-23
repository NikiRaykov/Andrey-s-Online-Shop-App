package bg.softuni.andrey.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    public User() {
    }

    @Column(unique = true)
    private String username;

    private String password;

    @Email
    private String email;

    @DecimalMin(value = "0")
    private BigDecimal budget;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
