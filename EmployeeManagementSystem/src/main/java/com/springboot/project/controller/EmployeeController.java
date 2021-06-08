package com.springboot.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.project.entity.Message;
import com.springboot.project.entity.Appraisal;
import com.springboot.project.entity.Employee;
import com.springboot.project.entity.Leave;
import com.springboot.project.entity.Salary;
import com.springboot.project.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

// to handle home page
	@RequestMapping("/")
	public String homeHandler() {

		return "home";

	}

//to handle Welcome page
	@RequestMapping("/welcome")
	public ModelAndView welcomeHandler(@RequestParam("name") String name, @RequestParam("password") String password,
			HttpSession session) {
		ModelAndView mv = new ModelAndView("welcome");
		Employee emp = employeeService.loginUser(name, password);

		if (emp == null) {
			Message msg = new Message("Invalid Details !try with another", "error", "alert-danger");
			session.setAttribute("msg", msg);
			mv.setViewName("home");
			return mv;
		}

		int id = emp.getId();
		session.setAttribute("id", id);
		session.setAttribute("name",name);
		mv.addObject("list", emp);
		session.setAttribute("currentuser", emp);
		mv.setViewName("welcome");
		return mv;
	}

//to handle Salary page	
	@RequestMapping("/salarypage")
	public ModelAndView salaryDetailsHandler(HttpSession session) {

		int id = (int) session.getAttribute("id");
		ModelAndView mv = new ModelAndView();
		List<Salary> list = employeeService.getSalary(id);
		if (list.isEmpty()) {
			mv.setViewName("salarypage");
			Message msg = new Message("list is Empty", "error", "alert-danger");
			session.setAttribute("msg", msg);
			return mv;
		}
		mv.addObject("salaries", list);
		mv.setViewName("salarypage");
		return mv;
	}

// to handle leave apply
	@RequestMapping("/leavepage")
	public ModelAndView leaveApplyHandler(HttpSession session) {
		int id = (int) session.getAttribute("id");
		ModelAndView mv = new ModelAndView();
		int day = employeeService.getAvailableLeave(id);
		session.setAttribute("leavedays", day);
		if (day <=0) {
			Message msg = new Message("You can't take leave!10 leaves compleated", "error", "alert-danger");
			session.setAttribute("msg", msg);
			mv.setViewName("leavepage");
			return mv;
		}

		mv.addObject("leaves", day);
		mv.setViewName("leavepage");

		return mv;
	}

	
	@RequestMapping("/leavesuccess")
	public ModelAndView leaveSuccess(@RequestParam("date") String date, @RequestParam("description") String description,
			HttpSession session) {

		int id = (int) session.getAttribute("id");
		int day = ((int) session.getAttribute("leavedays")) - 1;

		ModelAndView mv = new ModelAndView();
		
		int insert = employeeService.getLeave(id, date, description);
		mv.setViewName("leavepage");
		
		if(day<=0) {
			Message msg = new Message("You can't take leave! 10 leaves compleated", "error", "alert-danger");
			session.setAttribute("msg", msg);
			return mv;
		}
		employeeService.updateLeaveDay(id, day);

		session.setAttribute("leavedays", day);

		mv.addObject("leaves", day);
		Message msg = new Message("Applied Successfully!", "success", "alert-success");
		session.setAttribute("msg", msg);

		

		return mv;

	}

	@RequestMapping("/leavedetails")
	public ModelAndView leavedetails(HttpSession session) {

		int id = (int) session.getAttribute("id");
		List<Leave> leaves = employeeService.getLeaveDetails(id);
		ModelAndView mv = new ModelAndView();

		mv.addObject("viewLeave", leaves);
		mv.setViewName("leavedetails");
		return mv;
	}

	
//to handle Appresalpage
	@RequestMapping("/appraisalpage")
	public ModelAndView getAppraisalHandler(HttpSession session) {

		int id = (int) session.getAttribute("id");
		Appraisal app = employeeService.getAppraisal(id);
		ModelAndView mv = new ModelAndView();
		int appid = app.getId();
		String apppos = app.getPosition();
		String appdep = app.getDepartment();
		String appsup = app.getSupervisor();
		String apprevfrm = app.getReviewfrom();
		String apprevend = app.getReviewend();
		String appperrev = app.getPerformancereview();

		mv.addObject("id", appid);
		mv.addObject("pos", apppos);
		mv.addObject("dep", appdep);
		mv.addObject("sup", appsup);
		mv.addObject("af", apprevfrm);
		mv.addObject("ae", apprevend);
		mv.addObject("ar", appperrev);
		mv.setViewName("appraisalpage");
		return mv;
	}

//to handle back buttons
	@RequestMapping("/backtowelcome")
	public ModelAndView backtoHomeHandler() {
		ModelAndView mav = new ModelAndView("welcome");
		return mav;
	}


//to handle logout 	
	@RequestMapping("/logout")
	public ModelAndView logoutHandler(HttpSession session) {
		session.removeAttribute("currentname");
		Message m = new Message("Logout Successfully", "success", "alert-success");
		session.setAttribute("msg", m);
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

}