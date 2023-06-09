package com.example.grade.repositories;

import com.example.grade.models.CoursesForGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoursesForGroupRepository extends JpaRepository<CoursesForGroup, Integer> {

    @Query("select c.course.courseName.name from CoursesForGroup c JOIN StudentDegree s ON s.studentGroup.id = c.studentGroup.id " +
            "where s.student.email = ?1 and c.course.semester = ?2 and c.course.hours > 0")
    List<String> findByStudentEmailAndCourseSemester(String email, Integer semester);
}