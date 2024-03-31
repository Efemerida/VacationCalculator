package neoflex.controllers;


import neoflex.dto.CalculationResponse;
import neoflex.services.CalculationService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Controller
@Validated
public class CalculatorController {

    CalculationService calculating;

    public CalculatorController(CalculationService calculating) {
        this.calculating = calculating;
    }

    @GetMapping("/calculacte")
    public ResponseEntity<CalculationResponse> calculating(@RequestParam @Min(value = 0,
            message = "The number of days can't be less than zero") Integer countOfDays,
                                                           @RequestParam @Min(value = 0,
            message = "The value of salary can't be less than zero") Double averageSalary,
                                                           @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfStart){

        CalculationResponse calculationResponse = new CalculationResponse();
        calculationResponse.setSalary(calculating.calculate(countOfDays, averageSalary, dateOfStart));
        return new ResponseEntity<>(calculationResponse, HttpStatus.OK);
    }

}
