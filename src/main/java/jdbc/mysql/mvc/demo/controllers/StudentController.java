package jdbc.mysql.mvc.demo.controllers;

import jdbc.mysql.mvc.demo.models.Student;
import jdbc.mysql.mvc.demo.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class StudentController {

    Logger log = Logger.getLogger(StudentController.class.getName());

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/")
    public String index(Model model) {
        log.info("index action called...");

        List<Student> students = studentRepo.getStudents();
        model.addAttribute("students", students);

        return "index";
    }

}
