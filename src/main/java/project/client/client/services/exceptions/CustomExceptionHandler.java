package project.client.client.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateCpfException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateCpfException(
            DuplicateCpfException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
}