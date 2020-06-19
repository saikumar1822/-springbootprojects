package com.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.controller.EmployeeTrainingController;
import com.course.dto.TrainingDto;
import com.course.exception.CourseNotFoundException;
import com.course.exception.TrainingsListNotFoundException;
import com.course.model.Course;
import com.course.model.Training;
import com.course.repository.CourseRepository;
import com.course.repository.EmployeeTrainingRepository;

/**
 * 
 * @author sai
 * version 1.1
 * 
 *
 */
@Service
public class EmployeeTrainingService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeTrainingService.class);

	
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EmployeeTrainingRepository employeeTrainingRepository;
	/**
	 * 
	 * @param courseName
	 * @return sortedTrainginList
	 * @throws CourseNotFoundException
	 * @throws TrainingsListNotFoundException
	 */
	public List<Training> getAll(String courseName) throws CourseNotFoundException, TrainingsListNotFoundException{
		Course course=courseRepository.findByCourseName(courseName);
		if(course==null) {
			logger.info("course not found exception");
			throw new CourseNotFoundException("course not found");
		}
		List<Training>list=employeeTrainingRepository.findByCourse(course);
		if(list.isEmpty()) {
			logger.info("empty tarining list");
			throw new TrainingsListNotFoundException("course not found");
			
		}
		List<Training> sortedTrainginList=list.stream().sorted((i1,i2)->-i2.getStartDate().compareTo(i1.getStartDate())).collect(Collectors.toList());
		
		return sortedTrainginList;
		
	}
	

}
