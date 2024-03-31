package neoflex.services;


import neoflex.repositories.HolidaysRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalculationServiceImpl implements CalculationService {

    HolidaysRepository holidaysRepository;

    public CalculationServiceImpl(HolidaysRepository holidaysRepository) {
        this.holidaysRepository = holidaysRepository;
    }

    public BigDecimal calculate(int countOfDays, double averageSalary){

        return BigDecimal.valueOf(averageSalary / 29.3)
                .setScale(2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(countOfDays));
    }

    public BigDecimal calculate(int countOfDays, double averageSalary, LocalDate begin){

        int count = countOfDays;

        if(begin!=null) {
            count = 0;
            List<LocalDate> holidaysList = holidaysRepository.getHolidays();

            LocalDate currentDate = begin;

            for (int i = 0; i < countOfDays; i++) {

                if ((currentDate.getDayOfWeek().getValue() < 6) &&
                        (!holidaysList.contains(currentDate))) {
                    count++;
                }

                currentDate = currentDate.plusDays(1);
            }

        }

        return calculate(count, averageSalary);
    }


}
