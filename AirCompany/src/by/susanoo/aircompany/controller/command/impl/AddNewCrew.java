package by.susanoo.aircompany.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.controller.command.BasicAction;
import by.susanoo.aircompany.service.CrewService;
import by.susanoo.aircompany.service.impl.CrewServiceImpl;


public class AddNewCrew  implements BasicAction{
	private CrewService crewService = new CrewServiceImpl();

	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) {
		crewService.addCrew(req);
		try {
			resp.sendRedirect(req.getContextPath() +"/flights");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
