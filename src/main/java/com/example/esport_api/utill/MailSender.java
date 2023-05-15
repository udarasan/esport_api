package com.example.esport_api.utill;

/**
 * @author udarasan
 * @TimeStamp 2023-05-15 11:52
 * @ProjectDetails esport_api
 */
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.IOException;
public class MailSender {

    @Autowired
    private JavaMailSender emailSender;

    public int sendMail(
            String to, String subject, String text) throws MessagingException, IOException {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("esoftassigmenets@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            System.out.println("------------------------------>"+text+to+subject);
            emailSender.send(message);
            System.out.println("------------------------------>");
            return VarList.Created;
        }catch (Exception e){
            System.out.println(e);
            return VarList.Conflict;
        }

    }

}