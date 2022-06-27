package com.jdc.assigment.model.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.assigment.domain.OpenClass;
import com.jdc.assigment.domain.Registration;
import com.jdc.assigment.model.RegistrationModel;

public class RegistrationModelImpl implements RegistrationModel {

	private static final String SELECT_SQL =  """
			select oc.id, oc.start_date, oc.teacher,
			r.id classId, r.student, r.phone, r.email
			from open_class oc join registration r on oc.id = r.open_class_id
			where oc.teacher = ? and oc.start_date = ?
			""";

	private static final String INSERT = "insert into registration (open_class_id, student, phone, email) values (?, ?, ?, ?)";
	
//	select oc.id, oc.start_date, oc.teacher,
//	r.id, r.student, r.phone, r.email
//	from open_class oc join registration r on oc.id = r.id
	
	private DataSource dataSource;

	public RegistrationModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Registration> findByCourse(int openClassId, String openClassTeacher, String openClassDate) {
		var list = new ArrayList<Registration>();

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(SELECT_SQL)) {

			//stmt.setInt(1, openClassId);
			stmt.setString(1, openClassTeacher);
			stmt.setString(2, openClassDate);

			var rs = stmt.executeQuery();

			while (rs.next()) {

				var oc = new OpenClass();
				oc.setId(rs.getInt("classId"));
				oc.setTeacher(rs.getString("teacher"));
				oc.setStartDate(rs.getString("start_date")); // This could be Error
				
				var r = new Registration();
				r.setId(rs.getInt("id"));
				r.setOpenClass(oc);
				r.setStudent(rs.getString("student"));
				r.setPhone(rs.getString("phone"));
				r.setEmail(rs.getString("email"));

				list.add(r);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void create(Registration registration) {
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(INSERT)) {
			
			stmt.setInt(1, registration.getClassTeacherID());
			stmt.setString(2, registration.getStudent());
			stmt.setString(3, registration.getPhone());
			stmt.setString(4, registration.getEmail());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}








