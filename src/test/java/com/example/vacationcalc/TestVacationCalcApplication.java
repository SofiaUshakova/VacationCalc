package com.example.vacationcalc;

import org.springframework.boot.SpringApplication;

public class TestVacationCalcApplication {

    public static void main(String[] args) {
        SpringApplication.from(VacationCalcApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
