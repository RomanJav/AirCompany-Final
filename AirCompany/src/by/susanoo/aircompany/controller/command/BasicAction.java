package by.susanoo.aircompany.controller.command;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface BasicAction {

	void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
