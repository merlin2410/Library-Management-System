package com.Merlin.LibraryManagementSystem.service.impl;

import com.Merlin.LibraryManagementSystem.DTO.RequestDto.AuthorRequestDto;
import com.Merlin.LibraryManagementSystem.DTO.ResponseDto.AuthorResponseDto;
import com.Merlin.LibraryManagementSystem.entity.Author;
import com.Merlin.LibraryManagementSystem.exceptions.AuthorNotFoundException;
import com.Merlin.LibraryManagementSystem.repository.AuthorRepository;
import com.Merlin.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setEmail(authorRequestDto.getEmail());

        authorRepository.save(author);
        return "Author added successfully";
    }

    @Override
    public AuthorResponseDto getAuthorByEmail(String email) throws AuthorNotFoundException {
        try {
            Author author = authorRepository.findByEmail(email);
            AuthorResponseDto authorResponseDto = new AuthorResponseDto();
            authorResponseDto.setEmail(author.getEmail());
            authorResponseDto.setName(author.getName());
            authorResponseDto.setAge(author.getAge());

            return authorResponseDto;
        }
        catch (Exception e){
            throw new AuthorNotFoundException("Author doesn't exist");
        }
    }

}
