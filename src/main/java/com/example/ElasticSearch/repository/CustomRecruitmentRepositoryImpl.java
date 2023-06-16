package com.example.ElasticSearch.repository;

import com.example.ElasticSearch.domain.Recruitment;
import com.example.ElasticSearch.dto.RecruitmentDto;
import com.example.ElasticSearch.dto.SearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CustomRecruitmentRepositoryImpl implements CustomRecruitmentRepository {

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<RecruitmentDto> searchByCondition(SearchCondition searchCondition) {
        Criteria criteria = new Criteria(searchCondition.getSearchType()).contains(searchCondition.getSearchText());
        Query query = new CriteriaQuery(criteria);
        SearchHits<Recruitment> searchResultList = elasticsearchOperations.search(query, Recruitment.class);
        return searchResultList.stream()
                .map(recruitmentSearchResult -> RecruitmentDto.toDto(recruitmentSearchResult.getContent()))
                .collect(Collectors.toList());
    }
}