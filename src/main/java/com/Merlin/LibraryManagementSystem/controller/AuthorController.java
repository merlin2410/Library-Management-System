package com.Merlin.LibraryManagementSystem.controller;

import com.Merlin.LibraryManagementSystem.DTO.RequestDto.AuthorRequestDto;
import com.Merlin.LibraryManagementSystem.DTO.ResponseDto.AuthorResponseDto;
import com.Merlin.LibraryManagementSystem.exceptions.AuthorNotFoundException;
import com.Merlin.LibraryManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.addAuthor(authorRequestDto);
    }

    @GetMapping("/get-by-email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email") String email) throws AuthorNotFoundException {
        return authorService.getAuthorByEmail(email);
    }
}
