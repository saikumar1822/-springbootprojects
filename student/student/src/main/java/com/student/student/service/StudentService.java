package com.student.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.student.exceptions.NoStudentFoundException;
import com.student.student.exceptions.NullStudentDataFoundException;
import com.student.student.exceptions.StudentNotFoundException;
import com.student.student.model.Student;
import com.student.student.repository.StundentRepository;

@Service
public class StudentService {
	@Autowired
	StundentRepository stundentRepository;

	public Student saveStudent(Student student) {
		if (student != null) {
		return	stundentRepository.save(student);
		} else {
			throw new NullStudentDataFoundException();
		}

	}

	public Student getStudent(Long id) {

		Optional<Student> student = stundentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			throw new StudentNotFoundException();
		}
	}

	public void deleteStudent(Long id) {
		stundentRepository.deleteById(id);
		;
	}

	public List<Student> getAllStudents() {
		List<Student> students = stundentRepository.findAll();
		if (students.isEmpty()) {
			throw new NoStudentFoundException();
		}
		return students;
	}

	public Student getStudentByName(String name) {
		return stundentRepository.findByName(name);
		
	}

}
