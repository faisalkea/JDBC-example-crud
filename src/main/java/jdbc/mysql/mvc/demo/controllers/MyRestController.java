package jdbc.mysql.mvc.demo.controllers;

import jdbc.mysql.mvc.demo.models.User;
import jdbc.mysql.mvc.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class MyRestController {

    private Logger logger = Logger.getLogger(MyRestController.class.getName());

    @Autowired
    UserService userService;

    @GetMapping("/ajax")
    @ResponseBody
    public ResponseEntity<String> ajax() {
        logger.info("Get AJAX data");

        String data = "Dette er data fra BE";

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<User>> listAll() {
        logger.info("List all users");

        try {
            List<User> users = userService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {
            logger.severe("Something Went Wrong: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
        logger.info("List user by id: " + id);

        try {
            User userById = userService.findUserById(id);
            return new ResponseEntity<>(userById, HttpStatus.OK);

        } catch (Exception e) {
            logger.severe("Something went wrong: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        logger.info("Add user");

        try {
            User addedUser = userService.addUser(user);
            return new ResponseEntity<>(addedUser, HttpStatus.OK);

        } catch (Exception e) {
            logger.severe("Something went wrong: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        logger.info("Update user with id: " + id);

        try {
            User updatedUser = userService.updateUser(id, user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);

        } catch (Exception e) {
            logger.severe("Something went wrong: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        logger.info("Delete user with id: " + id);

        try {
            Boolean deleted = userService.deleteUser(id);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            logger.severe("Something went wrong: " + e);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/exist")
    public ResponseEntity<?> userExists(@RequestParam String name, @RequestParam String email) {
        logger.info("Does user exist");

        try {
            boolean exist = userService.userExist(name, email);
            if (exist) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            logger.severe("Something went wrong: " + e);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

