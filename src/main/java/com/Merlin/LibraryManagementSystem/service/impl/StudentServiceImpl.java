package com.Merlin.LibraryManagementSystem.service.impl;

import com.Merlin.LibraryManagementSystem.DTO.RequestDto.StudentRequestDto;
import com.Merlin.LibraryManagementSystem.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.Merlin.LibraryManagementSystem.DTO.ResponseDto.StudentResponseDto;
import com.Merlin.LibraryManagementSystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.Merlin.LibraryManagementSystem.entity.Card;
import com.Merlin.LibraryManagementSystem.entity.Student;
import com.Merlin.LibraryManagementSystem.enums.CardStatus;
import com.Merlin.LibraryManagementSystem.enums.Department;
import com.Merlin.LibraryManagementSystem.exceptions.StudentNotFoundException;
import com.Merlin.LibraryManagementSystem.repository.StudentRepository;
import com.Merlin.LibraryManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setValidTill("2026-02-13");
        card.setStudent(student);
        student.setCard(card);

        studentRepository.save(student);

        return "Student added";
    }

    @Override
    public UpdateStudentMobNoResponseDto updateMobileNumber(UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException {
        try {
            Student student = studentRepository.findById(updateStudentMobNoRequestDto.getId()).get();
            student.setMobNo(updateStudentMobNoRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();
            updateStudentMobNoResponseDto.setName(updatedStudent.getName());
            updateStudentMobNoResponseDto.setMobNo(updatedStudent.getMobNo());

            return updateStudentMobNoResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Student doesn't exist");
        }

    }

    @Override
    public StudentResponseDto getStudentById(int id) throws StudentNotFoundException{
        try {
            Student student = studentRepository.findById(id).get();
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            studentResponseDto.setAge(student.getAge());
            studentResponseDto.setDepartment(student.getDepartment());
            studentResponseDto.setName(student.getName());
            return studentResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Student doesn't exist");
        }
    }


}
