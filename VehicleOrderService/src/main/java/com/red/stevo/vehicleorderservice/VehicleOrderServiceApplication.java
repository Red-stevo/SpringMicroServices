package com.red.stevo.vehicleorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VehicleOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleOrderServiceApplication.class, args);
    }

}
