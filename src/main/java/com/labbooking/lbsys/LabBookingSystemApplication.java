package com.labbooking.lbsys;

import com.labbooking.lbsys.model.Equipment;
import com.labbooking.lbsys.model.Role;
import com.labbooking.lbsys.model.Status;
import com.labbooking.lbsys.model.User;
import com.labbooking.lbsys.repository.EquipmentRepository;
import com.labbooking.lbsys.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LabBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabBookingSystemApplication.class, args);
    }

    // Tells Spring Boot to allow traffic from our web browser, don't know how it works but it does.
    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            public void addCorsMapping(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
            }
        };
    }

    // Database Seeder
    @Bean
    public CommandLineRunner seedDatabase(UserRepository userRepository, EquipmentRepository equipmentRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new User(111111111L, Role.USER));
                userRepository.save(new User(222222222L, Role.USER));
                userRepository.save(new User(333333333L, Role.ADMIN));
            }

            if (equipmentRepository.count() == 0) {
                Equipment eq1 = new Equipment();
                eq1.setName("Lab Equipment 1");
                eq1.setStatus(Status.AVAILABLE);
                equipmentRepository.save(eq1);

                Equipment eq2 = new Equipment();
                eq2.setName("Lab Equipment 2");
                eq2.setStatus(Status.AVAILABLE);
                equipmentRepository.save(eq2);

                Equipment eq3 = new Equipment();
                eq3.setName("Lab Equipment 3");
                eq3.setStatus(Status.MAINTENANCE);
                equipmentRepository.save(eq3);

                Equipment eq4 = new Equipment();
                eq4.setName("Lab Equipment 4");
                eq4.setStatus(Status.AVAILABLE);
                equipmentRepository.save(eq4);
            }
        };
    }

}
