package com.survey.demo.services;

import com.survey.demo.DTOs.SurveyRequestDTO;
import com.survey.demo.EmailService;
import com.survey.demo.entities.DomainAdmin;
import com.survey.demo.entities.SurveyLink;
import com.survey.demo.repo.DomainAdminRepository;
import com.survey.demo.repo.SurveyLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class service {

@Autowired
private DomainAdminRepository domainAdminRepository;

@Autowired
private SurveyLinkRepository surveyLinkRepository;

@Autowired
private EmailService emailService;

    @Transactional
    public void saveEmails(SurveyRequestDTO surveyRequestDTO){
      SurveyLink surveyLink = new SurveyLink();
      List<DomainAdmin> domainAdminList = new ArrayList<DomainAdmin>();
      domainAdminList.addAll(surveyRequestDTO.getDomains());
      surveyLink.setUrl(surveyRequestDTO.getSurveyUrl());
      surveyLink.setDomainAdmins(domainAdminList);
      SurveyLink savedSurveyLink = surveyLinkRepository.save(surveyLink);
      domainAdminList.stream().forEach(domainAdmin -> domainAdmin.setSurveyLinkId(savedSurveyLink.getId()));
      domainAdminRepository.saveAll(domainAdminList);
    }

    public void sendEmails(){
      List<DomainAdmin> domainAdminList = domainAdminRepository.findAll();

      domainAdminList.stream().forEach(domainAdmin -> {
        emailService.sendEmail(domainAdmin.getAdminEmail(),"survey link",domainAdmin.getSurveyLink().getUrl());
        });


    }

}
