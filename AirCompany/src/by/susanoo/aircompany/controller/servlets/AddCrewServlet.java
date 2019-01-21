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

@WebServlet("/add_crew")
public class AddCrewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6442029251885920241L;

	public AddCrewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicAction basicAction = CommandManager.defineAction(COMMAND_ADD_CREW_GETPARAMS);
		basicAction.performAction(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BasicAction basicAction = CommandManager.defineAction(COMMAND_ADD_CREW);
		basicAction.performAction(request, response);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}

}
