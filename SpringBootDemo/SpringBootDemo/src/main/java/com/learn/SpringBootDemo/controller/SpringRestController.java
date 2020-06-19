package com.learn.SpringBootDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.SpringBootDemo.model.Employee;

@RestController
public class SpringRestController {
	
	@GetMapping("welcome")
	private String method1(){
		return "welcome to spring boot appliction";
	}

	@GetMapping("/getEmployee/{id}")
	private Employee method2(@PathVariable int id){
		if (id==1){
		return new Employee(1,"sai","male");
	}else
	{
		return new Employee();
	}
}
	@GetMapping("/getAllEmployees")
	private List<Employee> method3(){
	Employee e1=new Employee(1,"sai","male");
	Employee e2=new Employee(2,"kumar","male");
	Employee e3=new Employee(3,"pavan","male");
		List list=new ArrayList();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		return list;
	}
	
	
}
