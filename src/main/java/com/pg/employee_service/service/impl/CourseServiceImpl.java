package com.pg.employee_service.service.impl;

import com.pg.employee_service.dto.CourseDto;
import com.pg.employee_service.entity.Course;
import com.pg.employee_service.exceptions.CourseAlreadyExistsException;
import com.pg.employee_service.exceptions.CourseNotFoundException;
import com.pg.employee_service.mapper.CourseMapper;
import com.pg.employee_service.repository.CourseRepository;
import com.pg.employee_service.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public void createCourse(CourseDto courseDto) {

        Optional<Course> courseOptional = repository.findByTitle(courseDto.getTitle());
        if(courseOptional.isPresent()){
            throw new CourseAlreadyExistsException("Course with this title already exists");
        }

        // convert dto to entity
        Course course = CourseMapper.mapToCourse(courseDto, new Course());
        repository.save(course);
    }

    @Override
    public CourseDto fetchCourse(String title) {
        Course course = repository.findByTitle(title).orElseThrow(
                () ->  new CourseNotFoundException("Course does not exists for - " + title)
        );
        return CourseMapper.mapToCourseDto(course, new CourseDto());
    }

    @Override
    public Integer fetchCourseId(String title) {
        Course course = repository.findByTitle(title).orElseThrow(
                () ->  new CourseNotFoundException("Course does not exists for - " + title)
        );
        return course.getId();
    }

    public boolean updateEmployee(CourseDto courseDto) {
        boolean isUpdated = false;
        if(courseDto.getTitle() == null){
            return isUpdated;
        }
        Course course = repository.findByTitle(courseDto.getTitle()).orElseThrow(
                () ->  new CourseNotFoundException("Course does not exists for - " + courseDto.getTitle())
        );
        Course updatedCourse = CourseMapper.mapToCourse(courseDto, course);
        repository.save(updatedCourse);
        isUpdated = true;
        return isUpdated;
    }

    @Override
    public boolean deleteCourse(String title) {
        boolean isDeleted = false;
        if(title == null) return isDeleted;
        repository.deleteByTitle(title);
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public List<CourseDto> fetchAllCourses() {

        List<Course> courses = repository.findAll();

        return courses.stream()
                .map(course -> CourseMapper.mapToCourseDto(course, new CourseDto()))
                .collect(Collectors.toList());
    }
}
