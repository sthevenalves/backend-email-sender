package com.sthev.msemail.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

    public Email(EmailRequest emailRequest) {
        this.ownerRef = emailRequest.ownerRef();
        this.emailFrom = emailRequest.emailFrom();
        this.emailTo = emailRequest.emailTo();
        this.subject = emailRequest.subject();
        this.text = emailRequest.text();
    }

}
