package com.example.ElasticSearch.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@ToString
@Document(indexName = "recruitment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recruitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Field(name = "모집직종")
    private String occupation;

    @Field(name = "요구경력")
    private String requiredExp;

    @Field(name = "사업장 주소")
    private String address;

    @Field(name = "고용형태")
    private String employType;

    @Field(name = "사업장명")
    private String businessName;

    @Field(name = "임금형태")
    private String wageType;

    @Field(name = "임금")
    private int wage;

    @Field(name = "기업형태")
    private String companyType;

    @Field(name = "모집기간")
    private String period;
}