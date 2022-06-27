package com.jdc.assigment.model;

import java.util.List;

import com.jdc.assigment.domain.Course;

public interface CourseModel {
	
	List<Course> getAll();
	void save(Course course);
	Course findById(int id);

}
