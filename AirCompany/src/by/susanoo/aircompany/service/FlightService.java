package by.susanoo.aircompany.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.susanoo.aircompany.entity.Flight;

public interface FlightService {
	List<Flight> viewFlightList();
	void addFlight(HttpServletRequest req);
}
