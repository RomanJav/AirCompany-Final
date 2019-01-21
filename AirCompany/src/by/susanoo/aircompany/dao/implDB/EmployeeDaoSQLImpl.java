package by.susanoo.aircompany.dao.implDB;

import static by.susanoo.aircompany.dao.util.DaoConstantStorage.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import by.susanoo.aircompany.dao.EmployeeDao;
import by.susanoo.aircompany.entity.Employee;

public class EmployeeDaoSQLImpl implements EmployeeDao {

	@Override
	public Employee FindUser(String name, String password) {
		try {
			Class.forName(DYNAMIC_DRIVER_LOADING).getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				Statement loginStatement = conn.createStatement();
				ResultSet loginResultSet = loginStatement.executeQuery(String.format(REQUEST_EMPLOYEE_LOGIN, name, password));
				if (loginResultSet.next()) {
					return new Employee(loginResultSet.getString(1), loginResultSet.getString(2));
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

}
