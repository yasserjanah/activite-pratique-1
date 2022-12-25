package org.openlab.openlabeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OpenlabEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabEurekaServiceApplication.class, args);
    }

}
