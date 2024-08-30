package com.pg.employee_service.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// constructing a POJO here
public class EnrollmentDto {

    private String status;
    private Integer empId;
    private Integer courseId;

    // private String mobileNumber;
    // private String courseTitle
}

