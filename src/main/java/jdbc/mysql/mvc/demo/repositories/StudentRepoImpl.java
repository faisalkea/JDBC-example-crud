package jdbc.mysql.mvc.demo.repositories;

import jdbc.mysql.mvc.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepoImpl implements StudentRepo {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Student> getStudents() {
        String sql = "SELECT * FROM student";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        return this.template.query(sql, rowMapper);
    }

}
