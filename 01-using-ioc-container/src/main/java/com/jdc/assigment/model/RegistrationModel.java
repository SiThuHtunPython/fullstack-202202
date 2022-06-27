package com.jdc.assigment.model;

import java.util.List;

import com.jdc.assigment.domain.Registration;

public interface RegistrationModel {

	List<Registration> findByCourse(int openClassId, String openClassTeacher, String openClassDate);
	
	void create(Registration registration);
	
}
