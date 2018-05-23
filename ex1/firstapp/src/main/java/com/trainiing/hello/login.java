package com.trainiing.hello;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// [START example]
@SuppressWarnings("serial")
public class login extends HttpServlet {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		UserService userService = UserServiceFactory.getUserService();
		if (userService.isUserLoggedIn()) {
			// Save the relevant profile info and store it in the session.
			User user = userService.getCurrentUser();
			request.getSession().setAttribute("userEmail", user.getEmail());
			request.getSession().setAttribute("userId", user.getUserId());

			String destination = (String) request.getSession().getAttribute("loginDestination");
			if (destination == null) {
				destination = "/hello";
			}

			logger.log(Level.INFO, "logging destination " + destination);
			response.sendRedirect(destination);
		} else {
			response.sendRedirect(userService.createLoginURL("/login"));
			logger.log(Level.INFO, "logging destination /login");
		}
	}
}
// [END example]
