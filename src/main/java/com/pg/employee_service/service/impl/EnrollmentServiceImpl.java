package com.pg.employee_service.service.impl;

import com.pg.employee_service.dto.CourseDto;
import com.pg.employee_service.dto.EnrollmentDto;
import com.pg.employee_service.entity.Course;
import com.pg.employee_service.entity.Enrollment;
import com.pg.employee_service.exceptions.CourseNotFoundException;
import com.pg.employee_service.exceptions.EnrollmentNotFoundException;
import com.pg.employee_service.mapper.CourseMapper;
import com.pg.employee_service.mapper.EnrollmentMapper;
import com.pg.employee_service.repository.EnrollmentRepository;
import com.pg.employee_service.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements IEnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

    @Override
    public void createEnrollment(EnrollmentDto enrollmentDto) {

        // convert dto to entity
        Enrollment enrollment = EnrollmentMapper.mapToEnrollment(enrollmentDto, new Enrollment());
        repository.save(enrollment);

    }

    @Override
    public List<EnrollmentDto> fetchEnrollmentDetails(Integer employee_id) {
        List<Enrollment> enrollments = repository.findByEmpId(employee_id).orElseThrow(
                () -> new EnrollmentNotFoundException("Enrollment does not exists for this number.")
        );

        return enrollments.stream()
                .map(enrollment -> EnrollmentMapper.mapToEnrollmentDto(enrollment, new EnrollmentDto()))
                .collect(Collectors.toList());
    }

//    @Override
//    public boolean deleteEnrollment(Integer emp_id, Integer course_id) {
//        return false;
//    }

    @Override
    public List<EnrollmentDto> fetchAllEnrollments() {
        List<Enrollment> enrollmentList = repository.findAll();

        return enrollmentList.stream()
                .map(enrollment -> EnrollmentMapper.mapToEnrollmentDto(enrollment, new EnrollmentDto()))
                .collect(Collectors.toList());
    }
}
