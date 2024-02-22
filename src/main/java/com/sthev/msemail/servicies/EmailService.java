package com.sthev.msemail.servicies;

import com.sthev.msemail.domain.Email;
import com.sthev.msemail.domain.StatusEmail;
import com.sthev.msemail.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    EmailRepository repository;

    @Autowired
    JavaMailSender mailSender;

    @Transactional
    public Email sendEmail(Email email){
        email.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            mailSender.send(message);
            email.setStatusEmail(StatusEmail.PROCESSING);
        }catch (MailException ex){
            email.setStatusEmail(StatusEmail.ERROR);
        }finally {
            email.setStatusEmail(StatusEmail.SENT);
            return repository.save(email);
        }
    }

    public Optional<Email> findById(String id){
        return repository.findById(id);
    }

}
