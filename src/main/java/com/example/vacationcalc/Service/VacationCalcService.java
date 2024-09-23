package com.example.vacationcalc.Service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;
@Component
public class VacationCalcService {
    private static final Set<LocalDate> HOLIDAYS = Set.of(LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 5, 1),
            LocalDate.of(2024, 3, 8),
            LocalDate.of(2024, 2, 23))
            //даты праздников в формате LocalDate.of(год, месяц, день)
    ;

    public double calculateVacationPay(double averageSalary, int vacationDays) {
        return (averageSalary / 29.3) * vacationDays; // 29.3 - среднее количество дней в месяце
    }

    public double calculateVacationPayWithDates(double averageSalary, LocalDate startDate, LocalDate endDate) {
        int totalDays = 0;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (!isWeekend(date) && !HOLIDAYS.contains(date)) {
                totalDays++;
            }
        }
        return calculateVacationPay(averageSalary, totalDays);
    }

    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek().getValue() >= 6; // 6 - Сб, 7 - Вс
    }
}
