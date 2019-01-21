package by.susanoo.aircompany.dao.util;

public class DaoConstantStorage {

	public static final String DB_URL = "jdbc:mysql://localhost/susanoodb?serverTimezone=Europe/Moscow&useSSL=false";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "JJabramsloh1";
	public static final String DYNAMIC_DRIVER_LOADING = "com.mysql.cj.jdbc.Driver";

	public static final String REQUEST_GIVE_EMPLOYEE_ID = "SELECT employees.employee_id FROM employees WHERE employees.fullname='%1$s'";
	public static final String REQUEST_GIVE_ALL_EMPLOYEES = "SELECT employees.fullname, position.position_name FROM employees INNER JOIN position ON position.position_id=employees.position_id";
	public static final String REQUEST_GIVE_ALL_FLIGHTS = "SELECT * FROM susanoodb.flights";
	public static final String REQUEST_GIVE_ALL_EMPLOYEES_OF_EACH_FLIGHT = "SELECT employees.fullname, position.position_name FROM crew INNER JOIN employees ON employees.employee_id=crew.employee_id INNER JOIN flights ON flights.flight_id=crew.flights_id INNER JOIN position ON position.position_id=employees.position_id WHERE flights.flight_id='%1$s'";
	public static final String REQUEST_EMPLOYEE_LOGIN = "SELECT employees.fullname, position.position_name, employees.login, employees.password FROM susanoodb.employees INNER JOIN position ON position.position_id=employees.position_id WHERE employees.login='%1$s' AND employees.password='%2$s'";

	public static final String REQUEST_ADD_NEW_FLIGHT = "INSERT INTO susanoodb.flights (flight_id, departure_point, destination_point, departure_date) Values (?, ?, ?, ?)";
	public static final String REQUEST_ADD_NEW_CREW = "INSERT INTO susanoodb.crew (employee_id, flights_id) VALUES (?, ?)";
}
