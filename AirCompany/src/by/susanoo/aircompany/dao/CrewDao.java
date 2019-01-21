package by.susanoo.aircompany.dao;

import java.util.List;

import by.susanoo.aircompany.entity.Employee;

public interface CrewDao {
	List<Employee> getEmployees();
	void setCrew(int flight_id, List<Employee> crew);
}
