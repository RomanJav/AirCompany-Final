package by.susanoo.aircompany.dao.implDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static by.susanoo.aircompany.dao.util.DaoConstantStorage.*;

import by.susanoo.aircompany.dao.FlightDao;
import by.susanoo.aircompany.entity.Employee;
import by.susanoo.aircompany.entity.Flight;

public class FlightDaoSQLImpl implements FlightDao {

	@Override
	public List<Flight> getFlights() {
		List<Flight> flightList = new ArrayList<Flight>();
		try {
			Class.forName(DYNAMIC_DRIVER_LOADING).getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				Statement flightStatement = conn.createStatement();
				ResultSet flightResultSet = flightStatement.executeQuery(REQUEST_GIVE_ALL_FLIGHTS);
				while (flightResultSet.next()) {
					List<Employee> employeeList = new ArrayList<Employee>();
					Statement employeeStatement = conn.createStatement();
					ResultSet employeeResultSet = employeeStatement
							.executeQuery(String.format(REQUEST_GIVE_ALL_EMPLOYEES_OF_EACH_FLIGHT, flightResultSet.getInt(1)));
					while (employeeResultSet.next()) {
						employeeList.add(new Employee(employeeResultSet.getString(1), employeeResultSet.getString(2)));
					}
					flightList.add(new Flight(flightResultSet.getInt(1), flightResultSet.getString(2),
							flightResultSet.getString(3), flightResultSet.getDate(4), employeeList));
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return flightList;
	}

	@Override
	public void setFlight(Flight flight) {
		try {
			Class.forName(DYNAMIC_DRIVER_LOADING).getDeclaredConstructor().newInstance();
			try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
				try (PreparedStatement preparedStatement = conn.prepareStatement(REQUEST_ADD_NEW_FLIGHT)) {
					preparedStatement.setInt(1, flight.getId());
					preparedStatement.setString(2, flight.getDeparturePoint());
					preparedStatement.setString(3, flight.getDestinationPoint());

					java.util.Date d = flight.getDepartureDate();
					java.sql.Date sd = new java.sql.Date(d.getTime());

					preparedStatement.setDate(4, sd);
					preparedStatement.executeUpdate();
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
