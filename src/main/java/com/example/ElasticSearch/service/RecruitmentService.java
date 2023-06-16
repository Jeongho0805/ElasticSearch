package com.example.ElasticSearch.service;

import com.example.ElasticSearch.dto.RecruitmentDto;
import com.example.ElasticSearch.dto.SearchCondition;
import com.example.ElasticSearch.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;

    public List<RecruitmentDto> findBySearchText(SearchCondition searchCondition) {
        return recruitmentRepository.searchByCondition(searchCondition);
    }
}