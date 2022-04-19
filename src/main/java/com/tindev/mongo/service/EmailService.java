package com.tindev.mongo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String tindev_mail;

    private final JavaMailSender emailSender;

    public void sendSimpleMessage(Long quantidadeDeLogs) {
        LocalDate data = LocalDate.now();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(tindev_mail);
        message.setTo(tindev_mail);
        message.setSubject("AVISO - Tindev - Logs");
        message.setText("Mensagem do Sistema de Logs:\n\n" +
                "Quantidade Logs do dia " + data.getDayOfMonth() + "/" + data.getMonthValue()  + ": " + quantidadeDeLogs + "\n\n" +
                "Atenciosamente,\n" +
                "Equipe Tindev");
        emailSender.send(message);
    }


}
