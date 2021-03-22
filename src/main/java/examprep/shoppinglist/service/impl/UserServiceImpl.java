package examprep.shoppinglist.service.impl;

import examprep.shoppinglist.model.entity.User;
import examprep.shoppinglist.model.service.UserServiceModel;
import examprep.shoppinglist.repository.UserRepository;
import examprep.shoppinglist.service.UserService;
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
    public void register(UserServiceModel userServiceModel) {
        this.userRepository.save(modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
       return userRepository.findByUsernameAndPassword(username, password)
                .map(user ->
                    modelMapper.map(user, UserServiceModel.class))
                .orElse( null);
    }
}
