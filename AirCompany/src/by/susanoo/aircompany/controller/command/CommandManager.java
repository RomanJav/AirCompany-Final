package by.susanoo.aircompany.controller.command;
import static by.susanoo.aircompany.controller.util.ControllerConstantStorage.*;

import by.susanoo.aircompany.controller.command.impl.AddNewCrew;
import by.susanoo.aircompany.controller.command.impl.AddNewFlight;
import by.susanoo.aircompany.controller.command.impl.DefaultActionImpl;
import by.susanoo.aircompany.controller.command.impl.GetNewCrewParams;
import by.susanoo.aircompany.controller.command.impl.LogIn;
import by.susanoo.aircompany.controller.command.impl.ViewFlightList;

public class CommandManager {

public static BasicAction defineAction(String action) {
		
		switch(action) {
		case COMMAND_FLIGHT_VIEW:
			return new ViewFlightList();
		case COMMAND_ADD_FLIGHT:
			return new AddNewFlight();
		case COMMAND_ADD_CREW:
			return new AddNewCrew();
		case COMMAND_ADD_CREW_GETPARAMS:
			return new GetNewCrewParams();
		case COMMAND_LOGIN:
			return new LogIn();
		default:
			return new DefaultActionImpl();	
		}
		
	}
}
