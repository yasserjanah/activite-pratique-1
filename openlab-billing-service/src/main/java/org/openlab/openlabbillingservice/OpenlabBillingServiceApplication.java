package org.openlab.openlabbillingservice;

import org.openlab.openlabbillingservice.dtos.InvoiceRequestDTO;
import org.openlab.openlabbillingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class OpenlabBillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabBillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(944320000), "C01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(717), "C01"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(34432000), "C02"));
        };
    }

}
