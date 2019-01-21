package by.susanoo.aircompany.controller.servlets.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static by.susanoo.aircompany.controller.util.ControllerConstantStorage.*;

public class SecurityConfig {
	static {
		init();
	}

	private static void init() {

		// Конфигурация для роли Диспетчера.
		List<String> urlPatterns1 = new ArrayList<String>();


		urlPatterns1.add("/add_crew");

		MAP_CONFIG.put(ROLE_DISPATCHER, urlPatterns1);

		// Конфигурация для роли Администратора.
		List<String> urlPatterns2 = new ArrayList<String>();


		urlPatterns2.add("/add_flight");

		MAP_CONFIG.put(ROLE_ADMINISTRATOR, urlPatterns2);
	}

	public static Set<String> getAllAppRoles() {
		return MAP_CONFIG.keySet();
	}

	public static List<String> getUrlPatternsForRole(String role) {
		return MAP_CONFIG.get(role);
	}
}
