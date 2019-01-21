package by.susanoo.aircompany.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.controller.command.BasicAction;
import by.susanoo.aircompany.controller.command.CommandManager;
import static by.susanoo.aircompany.controller.util.ControllerConstantStorage.*;

@WebServlet("/add_flight")
public class AddFlightServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4938014965688910311L;

	public AddFlightServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/add_flight.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			BasicAction basicAction = CommandManager.defineAction(COMMAND_ADD_FLIGHT);
			basicAction.performAction(request, response);
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}
}
