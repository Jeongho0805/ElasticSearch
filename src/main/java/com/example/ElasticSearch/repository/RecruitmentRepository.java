package com.example.ElasticSearch.repository;

import com.example.ElasticSearch.domain.Recruitment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RecruitmentRepository extends ElasticsearchRepository<Recruitment, Long> {

    Recruitment findRecruitmentByBusinessName(String name);
}