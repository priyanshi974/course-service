package com.pg.employee_service.controller;

import com.pg.employee_service.dto.CourseDto;
import com.pg.employee_service.dto.EnrollInputDto;
import com.pg.employee_service.dto.EnrollmentDto;
import com.pg.employee_service.dto.ResponseDto;
import com.pg.employee_service.entity.Course;
import com.pg.employee_service.model.ServiceCall;
import com.pg.employee_service.service.ICourseService;
import com.pg.employee_service.service.IEnrollmentService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(
        name = "Enrollment controller for CRUD operations",
        externalDocs = @ExternalDocumentation(
                url = "https://spring.io"
        )
)
@RestController
@RequestMapping("/api")
@Validated
public class EnrollmentController {

    // this helps us to inject the value from application.yml
    @Value("${build.version}")
    private String buildVersion;

    private final ServiceCall serviceCall;
    private final ICourseService iCourseService;
    private final IEnrollmentService iEnrollmentService;

    @Autowired
    public EnrollmentController(ServiceCall serviceCall, ICourseService iCourseService, IEnrollmentService iEnrollmentService) {
        this.serviceCall = serviceCall;
        this.iCourseService = iCourseService;
        this.iEnrollmentService = iEnrollmentService;
    }

    @Operation(
            description = "POST API to enroll employees to courses in the system"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Success in creating enrollment info"
    )
    @PostMapping("/ecreate")
    public ResponseEntity<ResponseDto> createEnrollment(@RequestBody @Valid EnrollInputDto enrollInputDto){

        Integer emp_id = serviceCall.getEmployeeId(enrollInputDto.getMobileNumber());
//        Integer course_id = ServiceCall.getCourseId(enrollInputDto.getCourseTitle());
        Integer course_id = iCourseService.fetchCourseId(enrollInputDto.getCourseTitle());

        // employee-service mei ek restAPI banegi jo mobile number input
        // krne pe emp_id degi, vo emp_id yahan use hogi.

        EnrollmentDto enrollmentDto = new EnrollmentDto();
        enrollmentDto.setStatus("Not completed");
        enrollmentDto.setEmpId(emp_id);
        enrollmentDto.setCourseId(course_id);
        iEnrollmentService.createEnrollment(enrollmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto("Created successfully", "201")
        );
    }

    @Operation(
            description = "POST API to fetch enrollments in the system"
    )
    @ApiResponse(
            responseCode = "202",
            description = "Success in fetching enrollment info"
    )
    @GetMapping("/efetch")
    public ResponseEntity<EnrollmentDto> fetchEnrollment(@RequestParam Integer emp_id){

        EnrollmentDto enrollmentDto = (EnrollmentDto) iEnrollmentService.fetchEnrollmentDetails(emp_id);
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentDto);
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

//    @Operation(
//            description = "POST API to delete enrollments in the system"
//    )
//    @ApiResponse(
//            responseCode = "200",
//            description = "Success in deleting enrollment info"
//    )
//    @DeleteMapping("/delete")
//    public ResponseEntity<ResponseDto> deleteEnrollment(@RequestParam String title){
//        boolean isDeleted =  iCourseService.deleteCourse(title);
//        if(isDeleted){
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseDto("Deleted Successfully", "200"));
//        }else{
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//                    new ResponseDto("Not deleted", "501"));
//        }
//    }

    @GetMapping("efetch-all")
    public ResponseEntity<List<EnrollmentDto>> fetchAllEnrollments() {
        List<EnrollmentDto> enrollmentDtoList = iEnrollmentService.fetchAllEnrollments();
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentDtoList);
    }

    // to access this we simply write api/greet
    @GetMapping("/egreet")
    public String greetEnroll(){
        return "Hello World";
    }

    @GetMapping("/ebuild-info")
    public String buildEnrollInfo(){
        return buildVersion;
    }
}
