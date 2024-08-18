package com.survey.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
public class SurveyLink {
  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String url;

  @OneToMany(mappedBy = "surveyLink", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @Fetch(FetchMode.JOIN)
  private List<DomainAdmin> domainAdmins;
}
