package by.susanoo.aircompany.dao;

import java.util.List;

import by.susanoo.aircompany.entity.Flight;

public interface FlightDao {
	List<Flight> getFlights();
	void setFlight(Flight flight);
}
