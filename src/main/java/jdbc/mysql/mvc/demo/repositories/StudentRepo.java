package jdbc.mysql.mvc.demo.repositories;

import jdbc.mysql.mvc.demo.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo {

    List<Student> getStudents();

}
