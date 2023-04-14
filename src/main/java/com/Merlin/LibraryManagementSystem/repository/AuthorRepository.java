package com.Merlin.LibraryManagementSystem.repository;

import com.Merlin.LibraryManagementSystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    public Author findByEmail(String email);
}
