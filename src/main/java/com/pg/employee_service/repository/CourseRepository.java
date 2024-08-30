package com.pg.employee_service.repository;

import com.pg.employee_service.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    // course may/ may not be available
    Optional<Course> findByTitle(String title);

    @Transactional
    @Modifying
    void deleteByTitle(String title);
}
