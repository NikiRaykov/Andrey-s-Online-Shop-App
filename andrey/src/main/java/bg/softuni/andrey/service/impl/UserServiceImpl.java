package bg.softuni.andrey.service.impl;

import bg.softuni.andrey.model.entity.User;
import bg.softuni.andrey.model.entity.service.UserServiceModel;
import bg.softuni.andrey.repository.UserRepository;
import bg.softuni.andrey.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        userRepository.save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return this.userRepository
                .findUserByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }
}
