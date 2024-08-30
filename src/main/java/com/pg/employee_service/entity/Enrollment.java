package com.pg.employee_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Enrollment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// constructing a POJO here
public class Enrollment {

    // this is the enrollment id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "course_id")
    private Integer course_id;

    private String status;

//    @NotEmpty
//    @Pattern(regexp = "(^$|[0-9]{10})", message = "Number should have 10 digits")
//    private String mobileNumber;
//
//    private String designation;
//    private String department;
}

