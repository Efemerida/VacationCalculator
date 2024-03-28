package neoflex.controllers;

import neoflex.dto.ExceptionResponse;
import neoflex.exceptions.WrongParametersException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ParametersExceptionHandler {

    @ExceptionHandler(value = WrongParametersException.class)
    public ResponseEntity<ExceptionResponse> numbersExceptionHandler(WrongParametersException ex){
        ExceptionResponse er = new ExceptionResponse();
        er.setStatus(400);
        er.setMessage(ex.getMessage());
        er.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> dateExceptionHandler(MethodArgumentTypeMismatchException ex){
        ExceptionResponse er = new ExceptionResponse();
        er.setStatus(400);
        er.setMessage("Illegal date format");
        er.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }



}
