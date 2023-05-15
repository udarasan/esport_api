package com.example.esport_api.utill;

import jakarta.mail.PasswordAuthentication;
import org.springframework.stereotype.Component;

/**
 * @author udarasan
 * @TimeStamp 2023-05-15 11:54
 * @ProjectDetails esport_api
 */
@Component
public class SMTPAuthenticator extends jakarta.mail.Authenticator{

    private final String senderEmailId="esoftassigmenets@gmail.com";
    // TODO: 5/25/2022  please make sure turn on google account less secure app access
    private final String senderPassword="djg6C014mZvzc5y8";//put your gmail password here

    public PasswordAuthentication getPasswordAuthentication() {
        System.out.println(senderEmailId);
        return new PasswordAuthentication(senderEmailId,
                senderPassword);
    }

}