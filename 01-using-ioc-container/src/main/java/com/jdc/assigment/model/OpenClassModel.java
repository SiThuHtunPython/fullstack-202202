package com.jdc.assigment.model;

import java.util.List;

import com.jdc.assigment.domain.OpenClass;

public interface OpenClassModel {
	
	List<OpenClass> findByCourse(int courseId);
	
	void create(OpenClass openClass);
	
	List<OpenClass> findByDetail(String startDate, String teacher);

}
