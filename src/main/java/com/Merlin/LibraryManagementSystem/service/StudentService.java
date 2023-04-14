package com.Merlin.LibraryManagementSystem.service;

import com.Merlin.LibraryManagementSystem.DTO.RequestDto.StudentRequestDto;
import com.Merlin.LibraryManagementSystem.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.Merlin.LibraryManagementSystem.DTO.ResponseDto.StudentResponseDto;
import com.Merlin.LibraryManagementSystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.Merlin.LibraryManagementSystem.entity.Student;
import com.Merlin.LibraryManagementSystem.exceptions.StudentNotFoundException;
import org.springframework.stereotype.Service;


public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDto);

    public UpdateStudentMobNoResponseDto updateMobileNumber(UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException;

    public StudentResponseDto getStudentById(int studentId) throws StudentNotFoundException;

}
