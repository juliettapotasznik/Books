package org.example.booksclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.security.auth.Subject;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookDto {
    private String key;
    private String title;
    @JsonProperty(value = "first_publish_year")
    private Year year;
    @JsonProperty(value = "author_name")
    private List<String> author;
    @JsonProperty(value = "author_key")
    private List<String> authorKey;



}
