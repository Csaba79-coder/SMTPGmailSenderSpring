package com.csaba79coder.SMTPGmailSenderSpring.controller;

import com.csaba79coder.SMTPGmailSenderSpring.email.MailSender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {

    @Getter
    @Setter
    private MailSender mailSender;

    public MailController(MailSender smtp) {
        this.mailSender = smtp;
    }

    @RequestMapping("/mail")
    public String mail() {
        // mailSender.send("mail@example.com", "A test mail Bean", "Body of the test mail with BEAN annotation!");
        try {
            mailSender.send("csabavadasz79@gmail.com", "first test email", "I learnt it at UDEMY!!!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Mail sent!";
    }
}
