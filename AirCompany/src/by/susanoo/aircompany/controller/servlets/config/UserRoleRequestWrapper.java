package by.susanoo.aircompany.controller.servlets.config;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UserRoleRequestWrapper extends HttpServletRequestWrapper {
 
    private String user;
    private String userRole = null;
    private HttpServletRequest realRequest;
 
    public UserRoleRequestWrapper(String user, String role, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.userRole = role;
        this.realRequest = request;
    }
 
    @Override
    public boolean isUserInRole(String role) {
        if (userRole == null) {
            return this.realRequest.isUserInRole(role);
        }
        return userRole.equals(role);
    }
 
    @Override
    public Principal getUserPrincipal() {
        if (this.user == null) {
            return realRequest.getUserPrincipal();
        }
 
        return new Principal() {
            @Override
            public String getName() {
                return user;
            }
        };
    }
}