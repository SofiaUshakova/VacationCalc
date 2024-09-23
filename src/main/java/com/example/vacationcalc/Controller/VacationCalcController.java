package com.example.vacationcalc.Controller;

import com.example.vacationcalc.Model.Request;
import com.example.vacationcalc.Service.VacationCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class VacationCalcController {
    @RestController
    @RequestMapping("/calculate")
    public class VacationCalculatorController {

        @Autowired
        private VacationCalcService calculatorService;

        @GetMapping
        public double calculate(@RequestBody Request request) {
            if (request.getStartDate() != null && request.getEndDate() != null) {
                return calculatorService.calculateVacationPayWithDates(request.getAverageSalary(), request.getStartDate(), request.getEndDate());
            } else {
                return calculatorService.calculateVacationPay(request.getAverageSalary(), request.getVacationDays());
            }
        }
    }
}
