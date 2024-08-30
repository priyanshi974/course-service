package com.pg.employee_service.mapper;

import com.pg.employee_service.dto.CourseDto;
import com.pg.employee_service.entity.Course;

public class CourseMapper {

    public static Course mapToCourse(CourseDto courseDto, Course course){

        course.setTitle(courseDto.getTitle());
        course.setAuthor(courseDto.getAuthor());
        course.setDuration(courseDto.getDuration());
        return course;
    }

    public static CourseDto mapToCourseDto(Course course, CourseDto courseDto){

        courseDto.setAuthor(course.getAuthor());
        courseDto.setTitle(course.getTitle());
        courseDto.setDuration(course.getDuration());
        return courseDto;
    }
}
