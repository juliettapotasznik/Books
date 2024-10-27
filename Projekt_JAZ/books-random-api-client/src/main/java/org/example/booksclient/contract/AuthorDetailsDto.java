package org.example.booksclient.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class AuthorDetailsDto {
    private String key;

    private String name;


    @JsonProperty(value = "top_work")
    private String topWork;
    @JsonProperty(value = "work_count")
    private Integer workCount;

}
