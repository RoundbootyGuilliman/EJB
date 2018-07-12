package app.controller;

import app.security.Authentication;
import app.security.AuthenticationException;
import app.security.AuthenticationManager;
import app.service.NewsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Controller {
	
	@WebServlet("/main")
	static class Main extends HttpServlet {
		
		@Inject
		NewsService newsService;
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setAttribute("newsList", newsService.getAllNews());
			request.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(request, response);
		}
	}
	
	@WebServlet("/news")
	static class News extends HttpServlet {
		
		@Inject
		NewsService newsService;
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setAttribute("news", newsService.getNewsById(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("WEB-INF/jsp/news.jsp").forward(request, response);
		}
	}
	
	@WebServlet("/add")
	static class Add extends HttpServlet {
		
		@Inject
		NewsService newsService;
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setAttribute("news", newsService.getNewsById(Integer.parseInt(request.getParameter("newsId"))));
			request.getRequestDispatcher("WEB-INF/jsp/add.jsp").forward(request, response);
		}
	}
	
	@WebServlet("/openLogin")
	static class OpenLogin extends HttpServlet {
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.getRequestDispatcher("WEB-INF/jsp/loginPage.jsp").forward(request, response);
		}
	}
	
	@WebServlet("/login")
	static class Login extends HttpServlet {
		
		@Inject
		AuthenticationManager authenticationManager;
		
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Authentication result = null;
			try {
				result = authenticationManager.authenticate(username, password);
			} catch (AuthenticationException e) {
				System.out.println("Authentication failed: " + e.getMessage());
				request.getRequestDispatcher("WEB-INF/jsp/loginPage.jsp").forward(request, response);
			}
			
			request.getSession().setAttribute("auth", result);
			
			System.out.println("Successfully authenticated.");
			
			request.getRequestDispatcher("WEB-INF/jsp/main.jsp").forward(request, response);
		}
	}
}
