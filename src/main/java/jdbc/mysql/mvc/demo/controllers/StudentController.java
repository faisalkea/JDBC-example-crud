package jdbc.mysql.mvc.demo.controllers;

import jdbc.mysql.mvc.demo.models.Student;
import jdbc.mysql.mvc.demo.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class StudentController {

    Logger log = Logger.getLogger(StudentController.class.getName());

    @Autowired
    StudentRepo studentRepo;

    ArrayList<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Faisal", "Jarkass", "fafj@kea.dk"));
        students.add(new Student(2, "Elisha", "Elisha", "elisha@kea.dk"));
        students.add(new Student(3, "Morten", "Mortensen", "morten@kea.dk"));
        students.add(new Student(4, "Jesper", "Nordentoft", "jesper@kea.dk"));
    }

    /*@GetMapping("/")
    public String index(Model model) {
        log.info("index called...");
        log.fine("Index: 0 -> " + students.get(0));

        model.addAttribute("students", students);

        return "index";
    }*/

    @GetMapping("/")
    public String index(Model model) {
        log.info("Index action called...");

        //List<Student> students = studentRepo.getStudents();
        //model.addAttribute("students", students);
        model.addAttribute("students", students);

        return "index";
    }

}
