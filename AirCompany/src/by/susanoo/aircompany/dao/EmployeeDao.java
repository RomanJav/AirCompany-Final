package by.susanoo.aircompany.dao;

import by.susanoo.aircompany.entity.Employee;

public interface EmployeeDao {
	Employee FindUser(String name, String password);
}
