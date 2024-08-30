package com.pg.employee_service.service;

import com.pg.employee_service.dto.CourseDto;
import com.pg.employee_service.dto.EnrollmentDto;

import java.util.List;

public interface IEnrollmentService {
    void createEnrollment(EnrollmentDto enrollmentDto);

    List<EnrollmentDto> fetchEnrollmentDetails(Integer employee_id);

//    boolean updateEmployee(CourseDto courseDto);

//    boolean deleteEnrollment(Integer emp_id, Integer course_id);

    List<EnrollmentDto> fetchAllEnrollments();
}
