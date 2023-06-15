package com.example.ElasticSearch;

import com.example.ElasticSearch.domain.Recruitment;
import com.example.ElasticSearch.repository.RecruitmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private RecruitmentRepository recruitmentRepository;

    @Test
    void Test() {
        Recruitment recruitment = recruitmentRepository.findRecruitmentByBusinessName("한국방송통신대학교 ");
        System.out.println(recruitment.toString());

    }
}