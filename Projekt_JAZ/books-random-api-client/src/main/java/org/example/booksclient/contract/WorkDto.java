package org.example.booksclient.contract;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class WorkDto {
    private String key;
    private String title;
    private List<AuthorDto> authors;
}
