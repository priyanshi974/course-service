package com.pg.employee_service.service;

import com.pg.employee_service.dto.CourseDto;
import com.pg.employee_service.entity.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    void createCourse(CourseDto courseDto);

    CourseDto fetchCourse(String title);

//    boolean updateEmployee(CourseDto courseDto);
    Integer fetchCourseId(String title);

    boolean deleteCourse(String title);

    List<CourseDto> fetchAllCourses();
}
