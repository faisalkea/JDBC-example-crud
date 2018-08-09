package jdbc.mysql.mvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"jdbc.mysql.mvc.demo"})
@SpringBootApplication
public class JdbcMvcMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcMvcMySqlApplication.class, args);
    }

}
