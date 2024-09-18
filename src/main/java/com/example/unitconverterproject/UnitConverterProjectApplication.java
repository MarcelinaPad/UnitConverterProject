package com.example.unitconverterproject;

import converter.UnitConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnitConverterProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitConverterProjectApplication.class, args);

        new UnitConverter().start();
    }

}
