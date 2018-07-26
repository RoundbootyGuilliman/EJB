package app.controller;

import app.security.Authentication;
import app.security.AuthenticationException;
import app.security.AuthenticationManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	@Inject
	private AuthenticationManager authenticationManager;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		
		System.out.println(email + password);
		Authentication result = null;
		try {
			result = authenticationManager.authenticate(email, password);
		} catch (AuthenticationException e) {
			System.out.println("Authentication failed: " + e.getMessage());
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("WEB-INF/jsp/loginPage.jsp").forward(request, response);
		}
		
		request.getSession().setAttribute("auth", result);
		
		System.out.println("Successfully authenticated");
		String path = (String) request.getSession().getAttribute("requestedPath");
		if (path == null || path.equals("")) {
			path = "/main";
		}
		response.sendRedirect(path);
	}
}