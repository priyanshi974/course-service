package com.pg.employee_service.dto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// constructing a POJO here
public class CourseDto {

//    private String id;
    private String title;
    private String author;
    private String duration;
}

