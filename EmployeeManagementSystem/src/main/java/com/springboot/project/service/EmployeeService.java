package com.springboot.project.service;

import java.util.List;

import com.springboot.project.entity.Appraisal;
import com.springboot.project.entity.Employee;
import com.springboot.project.entity.Leave;
import com.springboot.project.entity.Salary;

public interface EmployeeService {
	

	Employee loginUser(String name, String password);

	List<Salary> getSalary(int id);

	int getAvailableLeave(int id);

	List<Leave> getLeaveDetails(int id);

	int getLeave(int id, String date, String description);

	void updateLeaveDay(int id, int day);

	Appraisal getAppraisal(int id);

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	List<Employee> getEmployees(String name, String password);

	Integer createNewEmployee(Employee employee);

	Employee getEmployee(int id);

	void updateEmployee(Employee employee);

	void deleteEmployee(int id);
}
