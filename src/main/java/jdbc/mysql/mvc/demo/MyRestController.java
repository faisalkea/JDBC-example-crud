package jdbc.mysql.mvc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    JdbcTemplate template;

    @GetMapping
    public List<User> listAll(){
        String sql = "SELECT * FROM user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return this.template.query(sql, rowMapper);
    }

    @GetMapping("/{id}")
    public User FindUserById(@PathVariable("id") int id){
        String sql = "SELECT * FROM user WHERE id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = template.queryForObject(sql, rowMapper, id);
        return user;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        //Add article
        String sql = "INSERT INTO user (id, name, email) values (?, ?, ?)";
        template.update(sql, user.getId(), user.getName(), user.getEmail());

        sql = "SELECT articleId FROM articles WHERE title = ? and category=?";
        int userId = template.queryForObject(sql, Integer.class, user.getName(), user.getEmail());

        user.setId(userId);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        String sql = "UPDATE user SET name=?, email=? WHERE id=?";
        template.update(sql, user.getName(), user.getEmail(), user.getId());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        String sql = "DELETE FROM user WHERE id=?";
        template.update(sql, id);
    }

    @GetMapping("/exist")
    public boolean articleExists(@RequestParam String name, @RequestParam String email) {
        String sql = "SELECT count(*) FROM user WHERE name = ? and email=?";
        int count = template.queryForObject(sql, Integer.class, name, email);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }

}

