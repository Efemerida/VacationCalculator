package neoflex.services;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CalculationService {

    BigDecimal calculate(int countOfDays, double averageSalary, LocalDate begin);
    BigDecimal calculate(int countOfDays, double averageSalary);

}
