package com.flab.moduletrucker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ModuleTruckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleTruckerApplication.class, args);
    }

}
