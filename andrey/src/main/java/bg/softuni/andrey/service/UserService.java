package bg.softuni.andrey.service;

import bg.softuni.andrey.model.entity.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
