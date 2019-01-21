package by.susanoo.aircompany.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.controller.command.BasicAction;
import by.susanoo.aircompany.service.CrewService;
import by.susanoo.aircompany.service.FlightService;
import by.susanoo.aircompany.service.impl.CrewServiceImpl;
import by.susanoo.aircompany.service.impl.FlightServiceImpl;

public class GetNewCrewParams implements BasicAction{
	private FlightService flightService = new FlightServiceImpl();
	private CrewService crewService = new CrewServiceImpl();
	
	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("flights", flightService.viewFlightList());
		req.setAttribute("employees", crewService.viewCrewList());
		try {
			req.getRequestDispatcher("/WEB-INF/views/add_crew.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
