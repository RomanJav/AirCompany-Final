package by.susanoo.aircompany.entity;

import java.util.Date;
import java.util.List;

public class Flight {
	private int id;
	private String departurePoint;
	private String destinationPoint;
	private Date departureDate;
	private List<Employee> crew;

	public Flight() {
		super();
	}

	public Flight(int id, String departurePoint, String destinationPoint, Date departureDate) {
		this.setId(id);
		this.setDeparturePoint(departurePoint);
		this.setDestinationPoint(destinationPoint);
		this.setDepartureDate(departureDate);
	}

	public Flight(int id, String departurePoint, String destinationPoint, Date departureDate, List<Employee> crew) {
		this.setId(id);
		this.setDeparturePoint(departurePoint);
		this.setDestinationPoint(destinationPoint);
		this.setDepartureDate(departureDate);
		this.setCrew(crew);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getDeparturePoint() {
		return departurePoint;
	}

	private void setDeparturePoint(String departurePoint) {
		this.departurePoint = departurePoint;
	}

	public String getDestinationPoint() {
		return destinationPoint;
	}

	private void setDestinationPoint(String destinationPoint) {
		this.destinationPoint = destinationPoint;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	private void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public List<Employee> getCrew() {
		return crew;
	}

	private void setCrew(List<Employee> crew) {
		this.crew = crew;
	}
}
