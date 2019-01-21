package by.susanoo.aircompany.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.controller.command.BasicAction;
import by.susanoo.aircompany.controller.servlets.config.AppUtils;
import by.susanoo.aircompany.entity.Employee;
import by.susanoo.aircompany.service.SessionService;
import by.susanoo.aircompany.service.impl.SessionServiceImpl;

public class LogIn implements BasicAction {
	private SessionService sessionService = new SessionServiceImpl();

	@Override
	public void performAction(HttpServletRequest req, HttpServletResponse resp) {
		Employee employee = sessionService.LogIn(req, resp);
		AppUtils.storeLoginedUser(req.getSession(), employee);
		int redirectId = -1;
        try {
            redirectId = Integer.parseInt(req.getParameter("redirectId"));
        } catch (Exception e) {
        }
        String requestUri = AppUtils.getRedirectAfterLoginUrl(req.getSession(), redirectId);
        if (requestUri != null) {
            try {
				resp.sendRedirect(requestUri);
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else {
            try {
				resp.sendRedirect(req.getContextPath() + "/");
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
}