package com.example.ElasticSearch.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchCondition {

    private String searchText;

    private String searchType;
}
