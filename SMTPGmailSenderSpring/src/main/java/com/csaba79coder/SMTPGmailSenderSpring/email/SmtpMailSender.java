package com.csaba79coder.SMTPGmailSenderSpring.email;

import lombok.Getter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class SmtpMailSender implements MailSender {

    @Getter
    public static final Log LOG = LogFactory.getLog(SmtpMailSender.class);

    private final JavaMailSender javaMailSender;

    public SmtpMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(String email, String subject, String body) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message, true);

        helper.setSubject(subject);
        helper.setTo(email);
        helper.setText(body, true);
        javaMailSender.send(message);
    }
}
