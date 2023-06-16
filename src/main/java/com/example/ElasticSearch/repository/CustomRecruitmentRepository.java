package com.example.ElasticSearch.repository;

import com.example.ElasticSearch.dto.RecruitmentDto;
import com.example.ElasticSearch.dto.SearchCondition;
import java.util.List;

public interface CustomRecruitmentRepository {

    List<RecruitmentDto> searchByCondition(SearchCondition searchCondition);
}