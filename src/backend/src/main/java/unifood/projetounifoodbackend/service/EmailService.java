package unifood.projetounifoodbackend.service;


import jakarta.mail.internet.InternetAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import unifood.projetounifoodbackend.entity.Aluno;
import unifood.projetounifoodbackend.repository.AlunoRepository;

import java.util.UUID;

@Service
public class EmailService {

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("uni.food.puc@gmail.com");



        mailSender.send(message);
    }

    public void verifyAndSendEmail(String email) {
        Aluno aluno = alunoRepository.findOneByEmail(email);
        if (aluno == null) {
            throw new RuntimeException("Email não cadastrado");
        }

        String token = UUID.randomUUID().toString();
        logger.info("Generated token: {}", token);

        String subject = "Resete sua senha";
        String body = "Olá, " + aluno.getNome() + "!\n\n" +
                "Você solicitou a recuperação de senha para o email " + aluno.getEmail() + ".\n" +
                "Caso não tenha sido você, ignore este email.\n\n" +
                "Caso tenha sido você, use o token abaixo para resetar sua senha:\n" +
                "Token: " + token + "\n\n" +
                "Atenciosamente,\n" +
                "Equipe UniFood";

        logger.info("Sending verification email to: {}", email);
        sendEmail(email, subject, body);
    }
}
