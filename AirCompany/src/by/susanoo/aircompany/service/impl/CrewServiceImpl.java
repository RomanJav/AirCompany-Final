package by.susanoo.aircompany.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.susanoo.aircompany.dao.CrewDao;
import by.susanoo.aircompany.dao.implDB.CrewDaoSQLImpl;
import by.susanoo.aircompany.entity.Employee;
import by.susanoo.aircompany.service.CrewService;

public class CrewServiceImpl implements CrewService {
	private CrewDao sqlCrewDao;

	public CrewServiceImpl() {
		sqlCrewDao = new CrewDaoSQLImpl();
	}

	@Override
	public void addCrew(HttpServletRequest req) {
		int flight_id = Integer.parseInt(req.getParameter("flight_id"));
		sqlCrewDao.setCrew(flight_id, flightCrew(req));

	}

	private List<Employee> flightCrew(HttpServletRequest req){
		List<Employee> crew = new ArrayList<Employee>();
		crew.add(new Employee(req.getParameter("first_pilot"), "Pilot"));
		crew.add(new Employee(req.getParameter("second_pilot"), "Pilot"));
		crew.add(new Employee(req.getParameter("navigator"), "Navigator"));
		crew.add(new Employee(req.getParameter("radio_operator"), "Radio operator"));
		crew.add(new Employee(req.getParameter("flight_attendant_1"), "Flight attendant"));
		crew.add(new Employee(req.getParameter("flight_attendant_2"), "Flight attendant"));
		crew.add(new Employee(req.getParameter("flight_attendant_3"), "Flight attendant"));
		return crew;
	}

	@Override
	public List<Employee> viewCrewList() {
		return sqlCrewDao.getEmployees();
	}
}
