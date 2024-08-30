package com.pg.employee_service.repository;

import com.pg.employee_service.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    Optional<List<Enrollment>> findByEmpId(Integer empId);


//    void deleteByEmployeeId(Integer emp_id, Integer course_id);
}
