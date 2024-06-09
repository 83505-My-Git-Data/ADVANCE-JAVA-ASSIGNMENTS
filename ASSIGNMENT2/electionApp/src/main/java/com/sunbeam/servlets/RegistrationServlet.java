package com.sunbeam.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String idString =  req.getParameter("id");
		int id = Integer.parseInt(idString);
		String firstName =  req.getParameter("first_name");
		String lastName =  req.getParameter("first_name");
		String dobStr =  req.getParameter("dob");
		Date dob = Date.valueOf(dobStr);
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		String statusString =req.getParameter("status");
		int status = Integer.parseInt(statusString);
		String role = req.getParameter("role");
		
		
		User u =  new User(id,firstName, lastName, email, password, dob, status,role);
		try(UserDao ud = new UserDaoImpl())
		{
			int count = ud.save(u);
			String msg = "User Added: " + count;
			req.setAttribute("message", msg);
			ServletContext ctx = this.getServletContext();
			RequestDispatcher rd = ctx.getRequestDispatcher("/login");
			rd.forward(req, resp);
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException();
		}
	}

}
