package by.susanoo.aircompany.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.susanoo.aircompany.entity.Employee;


public interface CrewService {
	List<Employee> viewCrewList();
	void addCrew(HttpServletRequest req);
}
