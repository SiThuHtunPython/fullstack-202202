package com.jdc.assigment.model.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.assigment.domain.Course;
import com.jdc.assigment.domain.OpenClass;
import com.jdc.assigment.model.OpenClassModel;

public class OpenClassModelImpl implements OpenClassModel {
	
	private static final String SELECT_SQL = """
			select oc.id, oc.start_date, oc.teacher,
			c.id courseId, c.name, c.duration, c.fees, c.description
			from open_class oc join course c on oc.course_id = c.id
			where c.id = ?
			""";
	private static final String INSERT = "insert into open_class (course_id, start_date, teacher) values (?, ?, ?)";
	private static final String SELECT_SQL_QUERY = """
			select oc.id, oc.start_date, oc.teacher,
			c.id courseId, c.name, c.duration, c.fees, c.description
			from open_class oc join course c on oc.course_id = c.id
			where oc.start_date = ? and oc.teacher = ?
			""";
	private DataSource dataSource;

	public OpenClassModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<OpenClass> findByCourse(int courseId) {
		
		var list = new ArrayList<OpenClass>();
		
		try (var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(SELECT_SQL)) {
			
			stmt.setInt(1, courseId);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var c = new Course();
				c.setId(rs.getInt("courseId"));
				c.setName(rs.getString("name"));
				c.setFees(rs.getInt("fees"));
				c.setDuration(rs.getInt("duration"));
				c.setDescription(rs.getString("description"));
				
				var oc = new OpenClass();
				oc.setCourse(c);
				oc.setId(rs.getInt("id"));
				oc.setTeacher(rs.getString("teacher"));
				oc.setStartDate(rs.getString("start_date")); //This could be Error
				
				list.add(oc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void create(OpenClass openClass) {
		try(var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(INSERT)) {
			
			stmt.setInt(1, openClass.getCourseId());
			stmt.setString(2, openClass.getStartDate());
			stmt.setString(3, openClass.getTeacher());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OpenClass> findByDetail(String startDate, String teacher) {
		var list = new ArrayList<OpenClass>();
		
		try (var conn = dataSource.getConnection();
				var stmt = conn.prepareStatement(SELECT_SQL_QUERY)) {
			
			stmt.setString(1, startDate);
			stmt.setString(2, teacher);
			
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var c = new Course();
				c.setId(rs.getInt("courseId"));
				c.setName(rs.getString("name"));
				c.setFees(rs.getInt("fees"));
				c.setDuration(rs.getInt("duration"));
				c.setDescription(rs.getString("description"));
				
				var oc = new OpenClass();
				oc.setCourse(c);
				oc.setId(rs.getInt("id"));
				oc.setTeacher(rs.getString("teacher"));
				oc.setStartDate(rs.getString("start_date")); //This could be Error
				
				list.add(oc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
