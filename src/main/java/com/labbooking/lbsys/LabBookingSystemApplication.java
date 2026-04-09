package com.labbooking.lbsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class LabBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabBookingSystemApplication.class, args);
    }

}
