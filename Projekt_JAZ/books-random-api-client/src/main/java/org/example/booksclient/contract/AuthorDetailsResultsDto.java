package org.example.booksclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AuthorDetailsResultsDto {
    @JsonProperty(value = "docs")
    private List<AuthorDetailsDto> results;

    public List<AuthorDetailsDto> getResults() {
        return results;
    }

    public void setResults(List<AuthorDetailsDto> results) {
        this.results = results;
    }
}
