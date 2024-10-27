package org.example.booksclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookResultsDto {
    @JsonProperty(value = "docs")
    private List<BookDto> results;

    public List<BookDto> getResults() {
        return results;
    }

    public void setResults(List<BookDto> results) {
        this.results = results;
    }
}
