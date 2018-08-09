package jdbc.mysql.mvc.demo.repositories;

import jdbc.mysql.mvc.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DefaultRepo")
public class UserRepoImpl implements UserRepo {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return this.template.query(sql, rowMapper);
    }

    @Override
    public User findUserById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = template.queryForObject(sql, rowMapper, id);
        return user;
    }

    @Override
    public User addUser(User user) {
        String sql = "INSERT INTO user (id, name, email) values (?, ?, ?)";
        template.update(sql, user.getId(), user.getName(), user.getEmail());

        sql = "SELECT id FROM user WHERE name = ? and email=?";
        int userId = template.queryForObject(sql, Integer.class, user.getName(), user.getEmail());

        user.setId(userId);
        return user;
    }

    @Override
    public Boolean deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        return template.update(sql, id) >= 0;

    }

    @Override
    public User updateUser(int id, User user) {
        String sql = "UPDATE user SET name=?, email=? WHERE id=?";
        template.update(sql, user.getName(), user.getEmail(), user.getId());
        return findUserById(id);
    }

    public boolean userExist(String name, String email) {
        String sql = "SELECT count(*) FROM user WHERE name = ? and email=?";
        int count = template.queryForObject(sql, Integer.class, name, email);
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }
}
