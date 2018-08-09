package jdbc.mysql.mvc.demo.services;

import jdbc.mysql.mvc.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getUsers();

    User findUserById(int id);

    User addUser(User user);

    Boolean deleteUser(int id);

    User updateUser(int id, User user);

    boolean userExist(String name, String email);
}
