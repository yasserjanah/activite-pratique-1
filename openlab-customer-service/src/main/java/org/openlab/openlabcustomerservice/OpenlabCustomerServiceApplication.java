package org.openlab.openlabcustomerservice;

import org.openlab.openlabcustomerservice.dtos.CustomerRequestDTO;
import org.openlab.openlabcustomerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenlabCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabCustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C01", "Yasser", "yasser@janah.me"));
            customerService.save(new CustomerRequestDTO("C02", "Hamza", "hamza@derkaoui.me"));
        };
    }

}
