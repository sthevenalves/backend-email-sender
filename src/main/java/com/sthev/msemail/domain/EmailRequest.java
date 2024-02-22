package com.sthev.msemail.domain;

public record EmailRequest(
        String ownerRef,
        String emailFrom,
        String emailTo,
        String subject,
        String text
) {
}
