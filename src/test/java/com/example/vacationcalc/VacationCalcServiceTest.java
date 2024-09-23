package com.example.vacationcalc;

import com.example.vacationcalc.Service.VacationCalcService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class VacationCalcServiceTest {
    private final VacationCalcService calculatorService = new VacationCalcService();

    @Test
    public void testCalculateVacationPay() {
        double result = calculatorService.calculateVacationPay(60000, 10);
        assertEquals(2048.46, result, 0.01);
    }

    @Test
    public void testCalculateVacationPayWithDates() {
        double result = calculatorService.calculateVacationPayWithDates(60000, LocalDate.of(2024, 5, 1), LocalDate.of(2024, 5, 10));
        assertEquals(4096.92, result, 0.01); // Примерный результат с учетом рабочих дней
    }
}
