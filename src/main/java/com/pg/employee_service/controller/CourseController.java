package com.pg.employee_service.controller;

import com.pg.employee_service.dto.CourseDto;
import com.pg.employee_service.dto.ResponseDto;
import com.pg.employee_service.service.ICourseService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Course controller for CRUD operations",
        externalDocs = @ExternalDocumentation(
                url = "https://spring.io"
        )
)
@RestController
@RequestMapping("/api")
@Validated
public class CourseController {

    // this helps us to inject the value from application.yml
    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private ICourseService iCourseService;

    @Operation(
            description = "POST API to create new employees in the system"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Success in creating course info"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCourse(@RequestBody @Valid CourseDto courseDto){
        iCourseService.createCourse(courseDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto("Created successfully", "201")
        );
    }

    @Operation(
            description = "POST API to fetch courses in the system"
    )
    @ApiResponse(
            responseCode = "202",
            description = "Success in fetching course info"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CourseDto> fetchCourse(@RequestParam String title){
        CourseDto courseDto = iCourseService.fetchCourse(title);
        return ResponseEntity.status(HttpStatus.OK).body(courseDto);
    }

//    @Operation(
//            description = "POST API to update courses in the system"
//    )
//    @ApiResponse(
//            responseCode = "203",
//            description = "Success in updating course info"
//    )
//    @PutMapping("/update")
//    public ResponseEntity<ResponseDto> updateCourse(@RequestBody @Valid CourseDto courseDto) {
//        boolean isUpdated = iCourseService.updateCourse(courseDto);
//        if(isUpdated){
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseDto("Update successfully", "203")
//            );
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//                    new ResponseDto("Not updated", "501"));
//        }
//    }

    @Operation(
            description = "POST API to delete courses in the system"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Success in deleting course info"
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCourse(@RequestParam String title){
        boolean isDeleted =  iCourseService.deleteCourse(title);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseDto("Deleted Successfully", "200"));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseDto("Not deleted", "501"));
        }
    }

    @GetMapping("fetch-all")
    public ResponseEntity<List<CourseDto>> fetchAllCourses() {
        List<CourseDto> courseList = iCourseService.fetchAllCourses();
        return ResponseEntity.status(HttpStatus.OK).body(courseList);
    }

    // to access this we simply write api/greet
    @GetMapping("/greet")
    public String greet(){
        return "Hello World";
    }

    @GetMapping("/build-info")
    public String buildInfo(){
        return buildVersion;
    }
}
