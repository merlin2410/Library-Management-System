package com.Merlin.LibraryManagementSystem.DTO.ResponseDto;

import com.Merlin.LibraryManagementSystem.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponseDto {
    private String name;
    private Department department;
    private int age;

}
