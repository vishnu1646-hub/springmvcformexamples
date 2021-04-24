package com.techouts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(Employee employee) {
		String query = "insert into springemployee(employeename,salary,designation) values('"
				+ employee.getEmployeename() + "','" + employee.getSalary() + "','" + employee.getDesignation() + "')";
		return jdbcTemplate.update(query);
	}

	public int update(Employee employee) {
		String query = " update springemployee set employeename='" + employee.getEmployeename() + "', salary='"
				+ employee.getSalary() + "',designation='" + employee.getDesignation() + "' where id='"
				+ employee.getId() + "'";
		return jdbcTemplate.update(query);
	}

	public int delete(int id) {
		String query = " delete from springemployee where id = '" + id + "' ";
		return jdbcTemplate.update(query);
	}

	public Employee getEmployeeById(int id) {
		String query = "select * from springemployee where id=?";
		return jdbcTemplate.queryForObject(query, new Object[] { id },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public List<Employee> getEmployees() {
		return jdbcTemplate.query("select * from springemployee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet resultSet, int row) throws SQLException {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setEmployeename(resultSet.getString(2));
				employee.setSalary(resultSet.getFloat(3));
				employee.setDesignation(resultSet.getString(4));
				return employee;
			}
		});
	}
}
