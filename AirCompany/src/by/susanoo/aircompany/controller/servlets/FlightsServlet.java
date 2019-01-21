package by.susanoo.aircompany.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.controller.command.BasicAction;
import by.susanoo.aircompany.controller.command.CommandManager;
import static by.susanoo.aircompany.controller.util.ControllerConstantStorage.*;

@WebServlet("/flights")
public class FlightsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2602380893604959042L;

	public FlightsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicAction basicAction = CommandManager.defineAction(COMMAND_FLIGHT_VIEW);
		basicAction.performAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}

}
