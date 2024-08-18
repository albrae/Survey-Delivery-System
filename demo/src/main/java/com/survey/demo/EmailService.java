package com.survey.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class EmailService {

  @Autowired
  private JavaMailSender javaMailSender;



  public void sendEmail(String to, String subject, String body) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(body);
    try{
      log.info("email address : "+to +" subject : "+subject +" body : "+body);
      javaMailSender.send(message);
    }catch (Exception e){
      log.error(e.toString());
      }
  }



}
