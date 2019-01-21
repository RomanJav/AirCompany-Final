package by.susanoo.aircompany.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.controller.command.BasicAction;
import by.susanoo.aircompany.service.FlightService;
import by.susanoo.aircompany.service.impl.FlightServiceImpl;

public class AddNewFlight implements BasicAction {
	private FlightService flightService = new FlightServiceImpl();

	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) {
		flightService.addFlight(req);
		try {
			resp.sendRedirect(req.getContextPath() +"/flights");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
