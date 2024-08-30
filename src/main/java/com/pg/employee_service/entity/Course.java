package com.pg.employee_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// constructing a POJO here
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Course name cannot be empty")
    private String title;

    private String duration;

    @NotEmpty(message = "Author name cannot be empty")
    private String author;

//    @NotEmpty
//    @Pattern(regexp = "(^$|[0-9]{10})", message = "Number should have 10 digits")
//    private String mobileNumber;
//
//    private String designation;
//    private String department;
}
