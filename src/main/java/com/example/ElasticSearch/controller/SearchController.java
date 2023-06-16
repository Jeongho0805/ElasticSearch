package com.example.ElasticSearch.controller;

import com.example.ElasticSearch.dto.RecruitmentDto;
import com.example.ElasticSearch.dto.SearchCondition;
import com.example.ElasticSearch.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SearchController {

    private final RecruitmentService recruitmentService;

    @GetMapping("/search")
    public ResponseEntity<Object> search(SearchCondition searchCondition) {
        log.info("검색어 -> {}", searchCondition.toString());
        List<RecruitmentDto> recruitmentList = recruitmentService.findBySearchText(searchCondition);
        return ResponseEntity.ok().body(recruitmentList);
    }
}
