package neoflex.controllers;


import neoflex.dto.CalculationResponse;
import neoflex.exceptions.WrongParametersException;
import neoflex.services.CalculationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CalculatorController {

    CalculationService calculating;

    public CalculatorController(CalculationService calculating) {
        this.calculating = calculating;
    }

    @GetMapping("/calculacte")
    public ResponseEntity<CalculationResponse> calculating(@RequestParam Integer countOfDays,
                                                           @RequestParam Double averageSalary,
                                                           @RequestParam(required = false)
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfStart) throws WrongParametersException {

        CalculationResponse calculationResponse = new CalculationResponse();
        calculationResponse.setSalary(calculating.calculate(dateOfStart, countOfDays, averageSalary));
        return new ResponseEntity<>(calculationResponse, HttpStatus.OK);
    }

}
