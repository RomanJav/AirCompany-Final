package by.susanoo.aircompany.dao.implDB;

import static by.susanoo.aircompany.dao.util.DaoConstantStorage.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.susanoo.aircompany.dao.CrewDao;
import by.susanoo.aircompany.entity.Employee;

public class CrewDaoSQLImpl implements CrewDao {

	@Override
	public void setCrew(int flight_id, List<Employee> crew) {
		try {
			Class.forName(DYNAMIC_DRIVER_LOADING).getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				for (Employee employee : crew) {
					Statement statement = conn.createStatement();
					ResultSet resultSet = statement.executeQuery(String.format(REQUEST_GIVE_EMPLOYEE_ID, employee.getFullName()));
					int id=0;
					if(resultSet.next())
							id=resultSet.getInt(1);
					try (PreparedStatement preparedStatement = conn.prepareStatement(REQUEST_ADD_NEW_CREW)) {
						preparedStatement.setInt(1, id);
						preparedStatement.setInt(2, flight_id);
						preparedStatement.executeUpdate();
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Class.forName(DYNAMIC_DRIVER_LOADING).getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				Statement employeeStatement = conn.createStatement();
				ResultSet employeeResultSet = employeeStatement.executeQuery(REQUEST_GIVE_ALL_EMPLOYEES);
				while (employeeResultSet.next()) {
					employees.add(new Employee(employeeResultSet.getString(1), employeeResultSet.getString(2)));
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return employees;
	}

}
