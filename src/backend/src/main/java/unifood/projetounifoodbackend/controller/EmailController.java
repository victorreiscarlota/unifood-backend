package unifood.projetounifoodbackend.controller;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unifood.projetounifoodbackend.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public void sendEmail(@RequestBody EmailRequest emailRequest) {
        logger.info("Received request to send email: {}", emailRequest);
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
    }

    @PostMapping("/send-verification")
    public void sendVerificationEmail(@RequestBody EmailVerificationRequest emailVerificationRequest) {
        logger.info("Received request to send verification email: {}", emailVerificationRequest);
        emailService.verifyAndSendEmail(emailVerificationRequest.getEmail());
    }

    @Data
    public static class EmailRequest {
        private String to;
        private String subject;
        private String body;
    }

    @Data
    public static class EmailVerificationRequest {
        private String email;
    }
}
