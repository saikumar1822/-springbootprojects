package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}
