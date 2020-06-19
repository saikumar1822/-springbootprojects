package com.example.CourseService.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.CourseService.exceptions.CourseNotFoundException;
import com.example.CourseService.exceptions.NoCourseFoundException;
import com.example.CourseService.exceptions.NullDataFOundInCourseException;
import com.example.CourseService.exceptions.StudentNotFoundException;
import com.example.CourseService.model.Course;
import com.example.CourseService.model.Student;
import com.example.CourseService.repository.CourseRepository;


@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;

	public Course saveCourse(Course course) {
		if (course != null) {
			return courseRepository.save(course);
		} else {
			throw new NullDataFOundInCourseException();
		}
	}

	public Course getCourseById(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		if (course.isPresent()) {
			return course.get();
		} else {
			throw new CourseNotFoundException();
		}

	}

	public Course getCourseByTitle(String title) {
	Course course=	courseRepository.findByTitle(title);
	if(course==null) {
		throw new CourseNotFoundException();
	}
	else {
		return course;
	}

	}

	public void deleteCourseById(Long id) {
		courseRepository.deleteById(id);
	}

	public List<Course> getAllCourses() {
		
		List <Course> courses=courseRepository.findAll();
		if(courses.isEmpty()) {
			throw new NoCourseFoundException();
		}
		return courses;
	}


}
