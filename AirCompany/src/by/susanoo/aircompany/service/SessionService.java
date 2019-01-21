package by.susanoo.aircompany.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.entity.Employee;

public interface SessionService {
	Employee LogIn(HttpServletRequest req, HttpServletResponse resp);
}
