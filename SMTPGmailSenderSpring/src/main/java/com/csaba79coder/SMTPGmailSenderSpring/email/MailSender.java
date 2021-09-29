package com.csaba79coder.SMTPGmailSenderSpring.email;

import javax.mail.MessagingException;

public interface MailSender {

    void send(String email, String subject, String body) throws MessagingException;
}
