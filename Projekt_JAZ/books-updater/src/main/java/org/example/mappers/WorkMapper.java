package org.example.mappers;

import org.example.booksclient.contract.AuthorDto;
import org.example.booksclient.contract.WorkDto;
import org.example.model.Author;
import org.example.model.Work;
import org.example.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class WorkMapper implements IMap<WorkDto, Work> {
    private final AuthorMapper authorMapper;
    private final AuthorRepository repository;
    @Autowired
    public WorkMapper(AuthorMapper authorMapper, AuthorRepository repository) {
        this.authorMapper = authorMapper;
        this.repository = repository;
    }


    @Override
    public Work map(WorkDto workDto) {
        return map(workDto,new Work());
    }

    @Override
    public Work map(WorkDto workDto, Work work) {
        if (work == null) {
            work = new Work();
        }

        work.setKey(workDto.getKey());
        work.setTitle(workDto.getTitle());

        if (workDto.getAuthors() != null) {
            List<Author> authors = workDto.getAuthors().stream()
                    .map(authorDto -> authorMapper.map(authorDto, new Author()))
                    .collect(Collectors.toList());
            work.setAuthors(authors);
        }

        return work;


    }
    public WorkDto toDto(Work work) {
        WorkDto workDto = new WorkDto();
        workDto.setKey(work.getKey());
        workDto.setTitle(work.getTitle());

        if (work.getAuthors() != null) {
            List<AuthorDto> authorDtos = work.getAuthors().stream()
                    .map(author -> {
                        AuthorDto authorDto = new AuthorDto();
                        authorDto.setName(author.getName());
                        authorDto.setKey(author.getKey());
                        return authorDto;
                    })
                    .collect(Collectors.toList());
            workDto.setAuthors(authorDtos);
        }

        return workDto;
    }
}
