package com.petcare.commons.model.dto;

import java.util.List;
import java.util.Map;

public class SearchCriteriaDTO {
    private String searchTerm;
    private List<String> fields;
    private Map<String, Object> filters;
    private int page;
    private int size;
    private String sortBy;
    private String sortDirection;

}
