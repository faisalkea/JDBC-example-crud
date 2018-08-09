package jdbc.mysql.mvc.demo.repositories;

import jdbc.mysql.mvc.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo {

    List<User> getUsers();

    User findUserById(int id);

    User addUser(User user);

    Boolean deleteUser(int id);

    User updateUser(int id, User user);

    boolean userExist(String name, String email);

}
