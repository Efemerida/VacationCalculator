package neoflex.services;


import neoflex.exceptions.WrongParametersException;
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

    @Override
    public BigDecimal calculate(LocalDate begin, int countOfDays, double averageSalary) throws WrongParametersException {

        if(countOfDays<0) throw new WrongParametersException
                ("The number of days can't be less than zero");
        if(averageSalary<0) throw new WrongParametersException
                ("The value of salary can't be less than zero");
        if(begin == null){
            BigDecimal  vacation = BigDecimal.valueOf(countOfDays * averageSalary / 29.3);
            return vacation.setScale(2, RoundingMode.HALF_UP);
        }

        List<LocalDate> holidaysList = holidaysRepository.getHolidays();

        LocalDate currentDate = begin;
        int count = 0;
        for(int i = 0; i < countOfDays; i++){
            if((currentDate.getDayOfWeek().getValue() < 6) &&
                    (!holidaysList.contains(currentDate))) {
                count++;
            }
            currentDate = currentDate.plusDays(1);
        }

        BigDecimal  vacation = BigDecimal.valueOf(count * averageSalary / 29.3);
        return vacation.setScale(2, RoundingMode.HALF_UP);

    }
}
