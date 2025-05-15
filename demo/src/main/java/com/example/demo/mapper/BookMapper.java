package com.example.demo.mapper;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.BookRequestDTO;
import com.example.demo.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book book);
    Book toEntity(BookRequestDTO bookRequestDTO);
    void updateEntityFromDTO(BookRequestDTO bookRequestDTO, @MappingTarget Book book);
}