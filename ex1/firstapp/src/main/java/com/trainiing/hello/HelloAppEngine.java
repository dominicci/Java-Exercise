package com.trainiing.hello;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Logger;

@WebServlet(name = "HelloAppEngine", urlPatterns = { "/hello" })
public class HelloAppEngine extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		String thisUrl = request.getRequestURI();
		response.setContentType("text/html");
		response.getWriter().println("<head><title>Welcome</title>" 
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\"></head>"
				+ "<img src=\"google3.png\" alt=\"Google3 icon\" width=\"100\" height=\"100\">");
		
		if (request.getUserPrincipal() != null) {
			User user = userService.getCurrentUser();
			request.getSession().setAttribute("userEmail", user.getEmail());
			request.getSession().setAttribute("userId", user.getUserId());
			response.getWriter()
					.println("<p>Hello, " + request.getUserPrincipal().getName() + "</p>"
							+ "<p>" + user.getUserId() + " is your ID.</p>"
							+ "<p>Awesome seeing you here! If you're on your way out, please <a href=\""
							+ userService.createLogoutURL(thisUrl) + "\">leave through here!</a>.</p>");
		} else {
			response.getWriter()
					.println("<p>Do I know you from somehwere? Please <a href=\"" 
							+ userService.createLoginURL(thisUrl)
							+ "\">show me here!</a>.</p>");
		}
	}
}