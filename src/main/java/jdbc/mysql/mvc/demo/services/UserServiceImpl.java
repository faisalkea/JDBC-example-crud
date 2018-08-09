package jdbc.mysql.mvc.demo.services;

import jdbc.mysql.mvc.demo.models.User;
import jdbc.mysql.mvc.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DefaultService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.getUsers();
    }

    @Override
    public User findUserById(int id) {
        return userRepo.findUserById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepo.addUser(user);
    }

    @Override
    public Boolean deleteUser(int id) {
        return userRepo.deleteUser(id);
    }

    @Override
    public User updateUser(int id, User user) {
        return userRepo.updateUser(id, user);
    }

    @Override
    public boolean userExist(String name, String email) {
        return userRepo.userExist(name, email);
    }
}
