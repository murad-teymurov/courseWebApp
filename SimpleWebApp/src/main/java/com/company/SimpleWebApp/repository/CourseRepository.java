package com.company.SimpleWebApp.repository;

import com.company.SimpleWebApp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
