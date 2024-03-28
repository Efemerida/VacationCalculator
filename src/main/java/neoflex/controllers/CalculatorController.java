package neoflex.controllers;


import neoflex.dto.CalculateResponse;
import neoflex.exceptions.WrongParametersException;
import neoflex.services.CalculateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CalculatorController {

    CalculateService calculating;

    public CalculatorController(CalculateService calculating) {
        this.calculating = calculating;
    }

    @GetMapping("/calculacte")
    public ResponseEntity<CalculateResponse> calculating(@RequestParam Integer countOfDays,
                                                         @RequestParam Double averageSalary,
                                                         @RequestParam(required = false)
                                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfStart) throws WrongParametersException {

        CalculateResponse calculateResponse = new CalculateResponse();
        calculateResponse.setSalary(calculating.calculate(dateOfStart, countOfDays, averageSalary));
        return new ResponseEntity<>(calculateResponse, HttpStatus.OK);
    }

}
