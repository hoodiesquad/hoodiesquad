package site.hoodiesquad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import site.hoodiesquad.models.User;
import site.hoodiesquad.services.UserService;

@SpringBootApplication
public class HoodiesquadApplication {
//    @Autowired
//    private UserService userService;

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(HoodiesquadApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner CommandLineRunnerBean() {
//        return (args) -> {
//            System.out.println("InitializationComponent");
//
//            User user = new User();
//            user.setUsername("admin");
//            user.setPassword(env.getProperty("app.admin_password"));
//
//            userService.saveUser(user, "ADMIN");
//        };
//    }
}
