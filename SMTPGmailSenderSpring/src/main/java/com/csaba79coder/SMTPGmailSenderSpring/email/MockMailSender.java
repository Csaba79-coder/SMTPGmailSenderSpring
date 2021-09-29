package com.csaba79coder.SMTPGmailSenderSpring.email;

import lombok.Getter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;

public class MockMailSender implements MailSender {

    @Getter
    public static final Log LOG = LogFactory.getLog(MockMailSender.class);

    private JavaMailSender mockJavaMailSender;

    public MockMailSender() {
    }

    @Override
    public void send(String email, String subject, String body) {
        LOG.info("Sending MOCK email to: " + email);
        LOG.info("With subject: " + subject);
        LOG.info("and body " + body);
    }
}
