package com.survey.demo.repo;

import com.survey.demo.entities.SurveyLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyLinkRepository extends JpaRepository<SurveyLink, Long> {

}
