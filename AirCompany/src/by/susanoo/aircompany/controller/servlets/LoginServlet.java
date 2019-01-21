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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");  
        BasicAction basicAction = CommandManager.defineAction(COMMAND_LOGIN);
        basicAction.performAction(req, resp);
	}

}
