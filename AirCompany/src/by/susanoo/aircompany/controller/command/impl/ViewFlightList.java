package by.susanoo.aircompany.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.controller.command.BasicAction;
import by.susanoo.aircompany.service.FlightService;
import by.susanoo.aircompany.service.impl.FlightServiceImpl;

public class ViewFlightList implements BasicAction {
	private FlightService flightService = new FlightServiceImpl();

	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("flights", flightService.viewFlightList());
		try {
			req.getRequestDispatcher("/flights.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
