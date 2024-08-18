package com.survey.demo.controllers;

import com.survey.demo.DTOs.SurveyRequestDTO;
import com.survey.demo.services.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  private com.survey.demo.services.service service;

  @PostMapping("/create-survey")
  public void createSurveyLink(@RequestBody SurveyRequestDTO surveyRequestDTO){
      service.saveEmails(surveyRequestDTO);
  }
}
