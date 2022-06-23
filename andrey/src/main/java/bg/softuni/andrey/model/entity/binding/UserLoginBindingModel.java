package bg.softuni.andrey.model.entity.binding;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {

    public UserLoginBindingModel(){}

    @Length(min = 2, message = "Username must be more than two characters!")
    private String username;

    @Length(min = 2, message = "Password must be more than two characters!")
    private String password;

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
}
