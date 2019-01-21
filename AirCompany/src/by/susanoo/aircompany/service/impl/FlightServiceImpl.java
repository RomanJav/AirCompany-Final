package by.susanoo.aircompany.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.susanoo.aircompany.dao.FlightDao;
import by.susanoo.aircompany.dao.implDB.FlightDaoSQLImpl;
import by.susanoo.aircompany.entity.Flight;
import by.susanoo.aircompany.service.FlightService;

public class FlightServiceImpl implements FlightService {
	private FlightDao sqlFlightDao;

	public FlightServiceImpl() {
		this.sqlFlightDao = new FlightDaoSQLImpl();
	}

	@Override
	public List<Flight> viewFlightList() {
		return sqlFlightDao.getFlights();
	}

	@Override
	public void addFlight(HttpServletRequest req) {
		try {
			sqlFlightDao.setFlight(createFlight(req));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	private Flight createFlight(HttpServletRequest req) throws ParseException {
		int id = Integer.parseInt(req.getParameter("id"));
		String departurePoint = req.getParameter("departurePoint");
		String destinationPoint = req.getParameter("destinationPoint");
		Date departureDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date"));

		return new Flight(id, departurePoint, destinationPoint, departureDate);
	}

}
