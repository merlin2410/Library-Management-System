package com.Merlin.LibraryManagementSystem.service;

import com.Merlin.LibraryManagementSystem.DTO.RequestDto.AuthorRequestDto;
import com.Merlin.LibraryManagementSystem.DTO.ResponseDto.AuthorResponseDto;
import com.Merlin.LibraryManagementSystem.exceptions.AuthorNotFoundException;

public interface AuthorService {
    public String addAuthor(AuthorRequestDto authorRequestDto);

    public AuthorResponseDto getAuthorByEmail(String email) throws AuthorNotFoundException;
}
