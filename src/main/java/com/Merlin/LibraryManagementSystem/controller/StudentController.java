package com.Merlin.LibraryManagementSystem.controller;

import com.Merlin.LibraryManagementSystem.DTO.RequestDto.StudentRequestDto;
import com.Merlin.LibraryManagementSystem.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.Merlin.LibraryManagementSystem.DTO.ResponseDto.StudentResponseDto;
import com.Merlin.LibraryManagementSystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.Merlin.LibraryManagementSystem.entity.Student;
import com.Merlin.LibraryManagementSystem.exceptions.StudentNotFoundException;
import com.Merlin.LibraryManagementSystem.service.StudentService;
import com.Merlin.LibraryManagementSystem.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }

    @PutMapping("/update-mob-no")
    public UpdateStudentMobNoResponseDto updateMobileNumber(@RequestBody UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException {
        return studentService.updateMobileNumber(updateStudentMobNoRequestDto);
    }

    @GetMapping("/get-by-id")
    public StudentResponseDto getStudentById(@RequestParam("id") int id) throws StudentNotFoundException{
        return studentService.getStudentById(id);
    }
}
