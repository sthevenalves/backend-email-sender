package com.sthev.msemail.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MailException {
    @ExceptionHandler(org.springframework.mail.MailException.class)
    public ResponseEntity<ExceptionDetails> emailException (org.springframework.mail.MailException exception){
        ExceptionDetails errorDetails = ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .title("Internal Server Error")
                .details("An error occurred while sending email.")
                .developerMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
