package bg.softuni.andrey.model.entity.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import java.math.BigDecimal;

public class UserRegisterBindingModel {

    public UserRegisterBindingModel(){}

    @Length(min = 2, message = "Username must be more than two characters!")
    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Email
    private String email;

    @DecimalMin(value = "0", message = "Budget must be more or equal to 0!")
    private BigDecimal budget;

    @Length(min = 2, message = "Password must be more than two characters!")
    private String password;

    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
