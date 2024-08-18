package com.survey.demo;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
public class SendSurveyLinkJob {

  @Autowired
  private com.survey.demo.services.service service;


  @Scheduled(cron = "1 * * * * *")
  @SchedulerLock(name = "emails", lockAtLeastFor = "PT1M", lockAtMostFor = "PT2M")
   public void run(){
    String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));
    log.debug("send email job start at : " + currentDate);

    service.sendEmails();

    currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));
    log.debug("send email job end at : " + currentDate);

   }


}
