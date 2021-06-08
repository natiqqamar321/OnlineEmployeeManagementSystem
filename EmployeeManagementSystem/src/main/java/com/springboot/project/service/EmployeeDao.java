package com.springboot.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.project.entity.Appraisal;
import com.springboot.project.entity.Employee;
import com.springboot.project.entity.Leave;
import com.springboot.project.entity.Salary;
import com.springboot.project.mapper.EmployeeMapper;

@Service
public class EmployeeDao implements EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Transactional(readOnly = true)
	
	public Employee loginUser(String name,String password) {
		// TODO Auto-generated method stub
		return employeeMapper.loginUser(name,password);
	}
	
	@Override
	public List<Salary> getSalary(int id) {
		// TODO Auto-generated method stub
		return employeeMapper.getSalary(id);
	}
	
	
	@Override
	public int getAvailableLeave(int id) {
		// TODO Auto-generated method stub
		return employeeMapper.getAvailableLeave(id);
	}
	
	@Override
	public List<Leave> getLeaveDetails(int id)
	{
		return employeeMapper.getLeaveDetails(id);
		
	}
	
	@Override
	public int getLeave(int id,String date,String description)
	{
		return employeeMapper.getLeave( id,date,description);
		
	}
	
	
	@Override
	public void updateLeaveDay(int id,int day)
	{
		employeeMapper.updateLeaveDay(id,day);
	}
	
	
	@Override
	public Appraisal getAppraisal(int id)
	{
		return employeeMapper.getAppraisal(id);
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<Employee> getEmployees(String name,String password) {
		// TODO Auto-generated method stub
		return employeeMapper.getEmployees(name,password);
	}

	@Override
	public Integer createNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeMapper.saveEmployee(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeMapper.getEmployee(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.saveEmployee(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteEmployeeById(id);
		
	}

	

}
