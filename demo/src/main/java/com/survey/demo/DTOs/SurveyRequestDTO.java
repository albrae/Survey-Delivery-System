package com.survey.demo.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.survey.demo.entities.DomainAdmin;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class SurveyRequestDTO {
  @JsonProperty
  private String surveyUrl;
  @JsonProperty
  private List<DomainAdmin> domains;
}
