package com.hcl.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Employee addEmployee(Employee employee) {

		sessionFactory.openSession().save(employee);
		return employee;

	}

	@Override
	public Employee getEmployeeById(Long empId) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	@Override
	public Employee deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
		return employee;
	}

	@Override
	public Long deleteEmployeeById(Long empId) {
		sessionFactory.getCurrentSession().delete(empId);
		return empId;
		
	}

}
