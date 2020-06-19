package com.course.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.exception.CourseNotFoundException;
import com.course.exception.TrainingsListNotFoundException;
import com.course.model.Training;
import com.course.service.EmployeeTrainingService;

/**
 * 
 * @author sai
 * version 1.1
 * description =getting all the trainging along with the employee list
 *
 */
@RestController
public class EmployeeTrainingController {
	@Autowired
	EmployeeTrainingService employeeTrainingService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeTrainingController.class);
	/**
	 * 
	 * @param courseName
	 * @return Taring List
	 * @throws CourseNotFoundException
	 * @throws TrainingsListNotFoundException
	 */
	@GetMapping("/training")
	public ResponseEntity<List<Training>> getTrainingList(@RequestParam String courseName) throws CourseNotFoundException, TrainingsListNotFoundException{
		
		logger.info("EmployeeTrainingController"+"-------------------------------------");
		List<Training>list=employeeTrainingService.getAll(courseName);
		return new ResponseEntity<List<Training>>(list, HttpStatus.OK);
	}

}
