package com.sthev.msemail.controllers;

import com.sthev.msemail.domain.Email;
import com.sthev.msemail.domain.EmailRequest;
import com.sthev.msemail.servicies.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailRequest emailRequest){
        Email email = new Email(emailRequest);
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Optional<Email> findById(@PathVariable String id){
        return emailService.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<Email>> findAllEmails(){
        return new ResponseEntity<>(this.emailService.findAllEmails(), HttpStatus.OK);
    }
}
