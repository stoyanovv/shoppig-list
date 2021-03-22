package examprep.shoppinglist.service;

import examprep.shoppinglist.model.service.UserServiceModel;

public interface UserService {


    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
