package com.jdc.assigment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.assigment.domain.OpenClass;
import com.jdc.assigment.model.CourseModel;
import com.jdc.assigment.model.OpenClassModel;

@WebServlet(urlPatterns = {
		"classes",
		"class-edit"
})
public class OpenClassServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var courseId = req.getParameter("courseId");
		var courseModel = getBean("courseModel", CourseModel.class);
		var course = courseModel.findById(Integer.parseInt(courseId)); //Could be Error
		
		req.setAttribute("course", course);
		
		var page = switch(req.getServletPath()) {
		case "/classes" -> {
			var model = getBean("openClassModel", OpenClassModel.class);
			req.setAttribute("classes", model.findByCourse(Integer.parseInt(courseId)));
			yield "classes";
		}
		default -> {
			var model = getBean("openClassModel", OpenClassModel.class);
			req.setAttribute("classesedit", model.findByCourse(Integer.parseInt(courseId)));
			yield "class-edit";
		}
		};
		
		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var teacher = req.getParameter("teacher");
		var startDate = req.getParameter("startDate");
		var courseId = req.getParameter("course_id");
		
		var openClass = new OpenClass();
		openClass.setTeacher(teacher);
		openClass.setStartDate(startDate);
		openClass.setCourseId(Integer.parseInt(courseId));
		
		getBean("openClassModel", OpenClassModel.class).create(openClass);
		
		resp.sendRedirect("/");
	}

}








