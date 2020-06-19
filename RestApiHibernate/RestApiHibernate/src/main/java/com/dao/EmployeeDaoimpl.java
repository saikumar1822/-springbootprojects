package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public class EmployeeDaoimpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Employee createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.save(employee);
		return employee;
	}

	@Override
	public Employee readEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee readEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> readEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(employee);
		System.out.println("skkkkkkkkkk");
		return employee;
	}

	@Override
	public Employee deleteEmployeeById(int empNo) {

		 Session session =this.sessionFactory.getCurrentSession();

		 Employee obj=(Employee)session.load(Employee.class,empNo);

		 if(null!=obj){

		 session.delete( obj);

		 }

		 return obj;

		 }
	

	@Override
	public void deleteEmployeeByName(String empName) {
		Session session =this.sessionFactory.getCurrentSession();

		 Employee obj=(Employee) session.byNaturalId(Employee.class).load();

		 if(null!=obj){

		 session.delete( obj);

		 }
	}

}
