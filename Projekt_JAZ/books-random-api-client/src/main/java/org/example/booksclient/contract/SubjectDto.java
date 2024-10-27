package org.example.booksclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class SubjectDto {
    private String key;
    private String name;
    @JsonProperty(value = "work_count")
    private Integer workCount;
    private List<WorkDto> works=new ArrayList<>();

}
