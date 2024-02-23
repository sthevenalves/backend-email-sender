package com.sthev.msemail.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequest(
        @NotBlank(message = "Field cannot be null or empty")
        String ownerRef,

        @Email(message = "Insert a valid E-mail")
        String emailFrom,

        @Email(message = "Insert a valid E-mail")
        String emailTo,

        @NotBlank(message = "Field cannot be null or empty")
        String subject,

        @NotBlank(message = "Field cannot be null or empty")
        String text
) {
}
