package by.susanoo.aircompany.controller.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerConstantStorage {

	public static final String COMMAND_FLIGHT_VIEW = "view_flights";
	public static final String COMMAND_ADD_FLIGHT = "add_flight";
	public static final String COMMAND_ADD_CREW = "add_crew";
	public static final String COMMAND_ADD_CREW_GETPARAMS = "crew_params";
	public static final String COMMAND_LOGIN = "login";
	
	
	public static final String ROLE_DISPATCHER = "Dispatcher";
    public static final String ROLE_ADMINISTRATOR = "Administrator";
    public static final String ROLE_PILOT = "Pilot";
    public static final String ROLE_NAVIGATOR = "Navigator";
    public static final String ROLE_RADIO_OPERATOR = "Radio operator";
    public static final String ROLE_FLIGHT_ATTENDANT = "Flight attendant";
    public static final Map<String, List<String>> MAP_CONFIG = new HashMap<String, List<String>>();
}
