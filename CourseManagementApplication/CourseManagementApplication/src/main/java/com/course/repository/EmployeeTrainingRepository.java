package com.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.model.Course;
import com.course.model.Training;
@Repository
public interface EmployeeTrainingRepository extends JpaRepository<Training, Long>{

	List<Training> findByCourse(Course course);

}
