package com.nuc.lg.ibeacon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


// exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}
@SpringBootApplication
public class IbeaconApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbeaconApplication.class, args);
    }

}
