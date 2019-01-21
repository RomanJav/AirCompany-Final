package by.susanoo.aircompany.controller.servlets.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.susanoo.aircompany.controller.servlets.config.AppUtils;
import by.susanoo.aircompany.controller.servlets.config.SecurityUtils;
import by.susanoo.aircompany.controller.servlets.config.UserRoleRequestWrapper;
import by.susanoo.aircompany.entity.Employee;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

	public SecurityFilter() {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String servletPath = request.getServletPath();
		Employee employee = AppUtils.getLoginedUser(request.getSession());

		if (servletPath.equals("/LoginServlet")) {
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest wrapRequest = request;

		if (employee != null) {
			String userName = employee.getFullName();
			String position = employee.getPosition();

			wrapRequest = new UserRoleRequestWrapper(userName, position, request);
		}

		// —траницы требующие входа в систему.
		if (SecurityUtils.isSecurityPage(request)) {

			// ≈сли пользователь еще не вошел в систему,
			// Redirect (перенаправить) к странице логина.
			if (employee == null) {

				String requestUri = request.getRequestURI();

				// —охранить текущую страницу дл€ перенаправлени€ (redirect) после успешного
				// входа в систему.
				int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

				response.sendRedirect(wrapRequest.getContextPath() + "/index.jsp");
				return;
			}

			// ѕроверить пользователь имеет действительную роль или нет?
			boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
			if (!hasPermission) {

				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");

				dispatcher.forward(request, response);
				return;
			}
		}

		chain.doFilter(wrapRequest, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
