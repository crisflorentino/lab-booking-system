package com.labbooking.lbsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

// Disabling the automatic configuration for DataSource since our SQL Database isn't set up yet.
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LabBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabBookingSystemApplication.class, args);
    }

}
