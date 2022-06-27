package com.jdc.assigment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.assigment.domain.Registration;
import com.jdc.assigment.model.CourseModel;
import com.jdc.assigment.model.OpenClassModel;
import com.jdc.assigment.model.RegistrationModel;

@WebServlet(urlPatterns = {
		"registration",
		"registration-edit"
})
public class RegistrationServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var page = switch(req.getServletPath()) {
		case "/registration" -> {
			var openClassTeacher = req.getParameter("openClassTeacher");
			var openClassDate = req.getParameter("openClassDate");
			var openClassId = req.getParameter("openClassId");
			
			var openClassModel = getBean("openClassModel", OpenClassModel.class);
			var openClass = openClassModel.findByCourse(Integer.parseInt(openClassId));
			req.setAttribute("classes", openClass);

			var courseModel = getBean("courseModel", CourseModel.class);
			var course = courseModel.findById(Integer.parseInt(openClassId)); //Could be Error
			req.setAttribute("course", course);
			
			/////////////////////////////////
			req.setAttribute("classStartDate", openClassDate);
			req.setAttribute("classTeacher", openClassTeacher);
			
			var registrationModel = getBean("registrationModel", RegistrationModel.class);
			var registration = registrationModel.findByCourse(Integer.parseInt(openClassId), openClassTeacher, openClassDate);
			req.setAttribute("register", registration);
			
			yield "registration";
		}
		default -> {
			var teacher = req.getParameter("RclassTeacher");
			var date = req.getParameter("RclassStartDate");
			var openClassModel = getBean("openClassModel", OpenClassModel.class);
			var openClass = openClassModel.findByDetail(date, teacher);
			req.setAttribute("classesD", openClass);
			
			yield "registration-edit";
		}
		};
		
		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var classTeacherID = req.getParameter("classTeacherID");
		var student = req.getParameter("student");
		var email = req.getParameter("email");
		var phone = req.getParameter("phone");
		
		var registration = new Registration();
		registration.setClassTeacherID(Integer.parseInt(classTeacherID));
		registration.setStudent(student);
		registration.setEmail(email);
		registration.setPhone(phone);
		
		getBean("registrationModel", RegistrationModel.class).create(registration);
		
		resp.sendRedirect("/"); 
	}

}
