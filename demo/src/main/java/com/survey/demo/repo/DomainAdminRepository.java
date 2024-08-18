package com.survey.demo.repo;

import com.survey.demo.DTOs.SurveyRequestDTO;
import com.survey.demo.entities.DomainAdmin;
import com.survey.demo.entities.SurveyLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DomainAdminRepository extends JpaRepository<DomainAdmin,Long> {
}
