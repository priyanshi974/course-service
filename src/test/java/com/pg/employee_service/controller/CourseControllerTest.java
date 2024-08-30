package com.pg.employee_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pg.employee_service.dto.CourseDto;
import com.pg.employee_service.service.ICourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ICourseService iCourseService;

    @Test
    @DisplayName("POST /api/courses - Create Course")
    public void createCourse() throws Exception {
//        CourseDto courseDto = new CourseDto("Java Programming", "Priyanshi", "7 hrs");
//
//        doNothing().when(iCourseService).createCourse(any(CourseDto.class));
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/api/courses")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(courseDto)))
//                .andExpect(status().isCreated())
//                .andExpect((ResultMatcher) jsonPath("$.message", is("Created successfully")))
//                .andExpect((ResultMatcher) jsonPath("$.status", is("201")));
    }

    @Test
    @DisplayName("GET /api/courses/{courseId} - Fetch Course")
    public void fetchCourse() throws Exception {
//        CourseDto courseDto = new CourseDto("Java Programming", "Priyanshi", "7 hrs");
//
//        // Mock the service call
//        Mockito.when(iCourseService.fetchCourse("Java Programming")).thenReturn(courseDto);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/courses/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) jsonPath("$.title", is("Java Programming")))
//                .andExpect((ResultMatcher) jsonPath("$.author", is("Priyanshi")))
//                .andExpect((ResultMatcher) jsonPath("$duration", is("7 hrs")));
    }

    @Test
    @DisplayName("DELETE /api/courses/{courseId} - Delete Course")
    public void deleteCourse() throws Exception {
//        // Mock the service call
//        when(iCourseService.deleteCourse(anyInt())).thenReturn(true);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .delete("/api/courses/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.message", is("Course Deleted Successfully")))
//                .andExpect(jsonPath("$.status", is("200")));
    }
//
    @Test
    @DisplayName("GET /api/courses - Fetch All Courses")
    public void fetchAllCourses() throws Exception {
//        List<CourseDto> courses = Arrays.asList(
//                new CourseDto(1, "Java Programming", "Introductory course to Java"),
//                new CourseDto(2, "Spring Boot", "Intermediate course on Spring Boot")
//        );
//
//        // Mock the service call
//        when(iCourseService.fetchAllCourses()).thenReturn(courses);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/courses")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].title", is("Java Programming")))
//                .andExpect(jsonPath("$[1].id", is(2)))
//                .andExpect(jsonPath("$[1].title", is("Spring Boot")));
    }
}
