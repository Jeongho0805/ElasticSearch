package com.example.ElasticSearch.dto;

import com.example.ElasticSearch.domain.Recruitment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class RecruitmentDto {

    private String occupation;

    private String requiredExp;

    private String address;

    private String employType;

    private String businessName;

    private String wageType;

    private int wage;

    private String companyType;

    private String period;

    public static RecruitmentDto toDto(Recruitment recruitment) {
        return RecruitmentDto.builder()
                .occupation(recruitment.getOccupation())
                .address(recruitment.getAddress())
                .businessName(recruitment.getBusinessName())
                .requiredExp(recruitment.getRequiredExp())
                .employType(recruitment.getEmployType())
                .wageType(recruitment.getWageType())
                .wage(recruitment.getWage())
                .companyType(recruitment.getCompanyType())
                .period(recruitment.getPeriod())
                .build();
    }
}