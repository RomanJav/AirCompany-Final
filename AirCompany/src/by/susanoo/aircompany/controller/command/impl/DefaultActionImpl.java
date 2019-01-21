package by.susanoo.aircompany.controller.command.impl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.controller.command.BasicAction;

public class DefaultActionImpl implements BasicAction {

	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("No such menu item");
	}
}
