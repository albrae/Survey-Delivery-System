package com.survey.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Data
@Entity
public class DomainAdmin {
  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String domainName;
  @Column
  private String adminEmail;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "survey_link_id", nullable = false, insertable = false , updatable = false)
  @Fetch(FetchMode.JOIN)
  private SurveyLink surveyLink;

  @Column(name="survey_link_id")
  private Long surveyLinkId;


}
