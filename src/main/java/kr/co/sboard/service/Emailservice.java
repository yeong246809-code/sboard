package kr.co.sboard.service;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;


@Log4j2
@Service
@RequiredArgsConstructor
public class Emailservice {

    @Value("${spring.mail.username}")
    private String sender;

    private final JavaMailSender ms;

    public String sendcode(String receiver){
        int code = ThreadLocalRandom.current().nextInt(100000,1000000);
        String title = "sboard 인증코드입니다.";
        String content = "<h1> 인증코드는 " + code + "입니다.<h1>";

        MimeMessage message = ms.createMimeMessage();
        try {
            message.setFrom(new InternetAddress(sender, "보내는사람", "UTF-8"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
            message.setSubject(title);
            message.setContent(content,"text/html;charset=UTF-8");
            ms.send(message);

        }catch (Exception e){
            log.error(e.getMessage());
        }
        return String.valueOf(code);
    }

    public void verifycode(){

    }


}
