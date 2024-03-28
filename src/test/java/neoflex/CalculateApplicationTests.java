package neoflex;

import neoflex.exceptions.WrongParametersException;
import neoflex.repositories.HolidaysRepositoryImpl;
import neoflex.services.CalculateService;
import neoflex.services.CalculateServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CalculateApplicationTests {

	@Test
	void contextLoads() {
	}



}
