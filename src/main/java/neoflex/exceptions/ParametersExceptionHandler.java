package neoflex.exceptions;

import neoflex.dto.ExceptionResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ParametersExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleException(ConstraintViolationException ex) {
        ExceptionResponse er = new ExceptionResponse();
        er.setStatus(400);
        er.setMessage(ex.getMessage());
        er.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> dateExceptionHandler(){

        ExceptionResponse er = new ExceptionResponse();
        er.setStatus(400);
        er.setMessage("Illegal date format");
        er.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }

}
