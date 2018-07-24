package app.controller;

import app.entity.User;
import app.service.UserService;
import app.util.MD5Encoder;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
	
	@Inject
	private UserService userService;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(MD5Encoder.encode(request.getParameter("password")));
		user.setRole("USER");
		userService.registerNewUserAccount(user);
		request.getRequestDispatcher("/login").forward(request, response);
	}
}