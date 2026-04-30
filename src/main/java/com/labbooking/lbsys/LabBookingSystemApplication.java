package com.labbooking.lbsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

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

}
