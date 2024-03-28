package neoflex;

import neoflex.exceptions.WrongParametersException;
import neoflex.services.CalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculationServiceTests {

    @Autowired
    CalculationService calculationService;

    @Test
    void calculateServiceWithDateTest() throws WrongParametersException {
        BigDecimal vacation = calculationService.calculate(LocalDate.of(2024,1,1),
                16, 1000);
        assertEquals(vacation, BigDecimal.valueOf(204.78));
    }

    @Test
    void calculateServiceWithoutDateTest() throws WrongParametersException {
        BigDecimal vacation = calculationService.calculate(null,6, 1000);
        assertEquals(vacation, BigDecimal.valueOf(204.78));
    }


}
