package by.susanoo.aircompany.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.dao.EmployeeDao;
import by.susanoo.aircompany.dao.implDB.EmployeeDaoSQLImpl;
import by.susanoo.aircompany.entity.Employee;
import by.susanoo.aircompany.service.SessionService;

public class SessionServiceImpl implements SessionService {
	private EmployeeDao employeeDao;

	public SessionServiceImpl() {
		employeeDao = new EmployeeDaoSQLImpl();
	}

	@Override
	public Employee LogIn(HttpServletRequest req, HttpServletResponse resp) {
		
		return employeeDao.FindUser(req.getParameter("name"), req.getParameter("password"));
	}

}
