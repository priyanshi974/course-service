package com.pg.employee_service.mapper;

import com.pg.employee_service.dto.CourseDto;
import com.pg.employee_service.dto.EnrollmentDto;
import com.pg.employee_service.entity.Course;
import com.pg.employee_service.entity.Enrollment;

public class EnrollmentMapper {

    public static Enrollment mapToEnrollment(EnrollmentDto enrollmentDto, Enrollment enrollment){

        enrollment.setEmpId(enrollmentDto.getEmpId());
        enrollment.setStatus(enrollmentDto.getStatus());
        enrollment.setCourse_id(enrollmentDto.getCourseId());
        return enrollment;
    }

    public static EnrollmentDto mapToEnrollmentDto(Enrollment enrollment, EnrollmentDto enrollmentDto){

        enrollmentDto.setEmpId(enrollment.getEmpId());
        enrollmentDto.setCourseId(enrollment.getCourse_id());
        enrollmentDto.setStatus(enrollment.getStatus());
        return enrollmentDto;
    }
}
