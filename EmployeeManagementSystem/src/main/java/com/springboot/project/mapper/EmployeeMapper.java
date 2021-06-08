package com.springboot.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springboot.project.entity.Appraisal;
import com.springboot.project.entity.Employee;
import com.springboot.project.entity.Leave;
import com.springboot.project.entity.Salary;

@Mapper
public interface EmployeeMapper {

	//for check  name password from database and login
	@Select("select * from employeedetial where name=#{name} and password=#{password}")
	Employee loginUser(String name, String password);

	//to fetch the salary of particular employee by id
	@Select("select * from employeesalary where id=#{id}")
	List<Salary> getSalary(int id);
    
	//to fetch available leaves of particular employee by id
	@Select("select days from leaveavailable where id=#{id}")
	int getAvailableLeave(int id);
   
	//to fetch leave details of particular employee by id
	@Select("select * from leavetable where id=#{id}")
	List<Leave> getLeaveDetails(int id);
   
	@Insert("insert into leavetable(id,date,description) values(#{id},#{date},#{description})")
	int getLeave(int id, String date, String description);

	@Update("update leaveavailable set days=#{days} where id=#{id}")
	public void updateLeaveDay(int id, int days);

	@Select("select * from appraisaltable where id=#{id}")
	Appraisal getAppraisal(int id);

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Select("select * from employeedetial where name=#{name} and password=#{password} ")
	List<Employee> getEmployees(String name, String password);

	@Insert("insert into employee(fullname,username,department) values(#{fullname},#{username},#{department})")
	Integer saveEmployee(Employee employee);

	@Update("update employee set department=#{department} where id=#{id}")
	public void updateEmployee(Employee employee);

	@Delete("delete from employee where id=#{id}")
	public void deleteEmployeeById(int id);

	@Select("select * from employee where id=#{id}")
	Employee getEmployee(int id);

}
