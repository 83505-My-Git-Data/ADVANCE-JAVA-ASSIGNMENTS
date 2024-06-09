package com.sunbeam.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.CDATASection;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;
@WebServlet("/deletecand")

public class DeleteCandidateServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idStr = req.getParameter("id");
		int id =  Integer.parseInt(idStr);
		try(CandidateDao cd =  new CandidateDaoImpl())
		{
			int count = cd.deleteById(id);
			String msg = "Candidates Deleted: " + count;
			req.setAttribute("message", msg);
			ServletContext ctx = this.getServletContext();
			RequestDispatcher rd = ctx.getRequestDispatcher("/result");
			rd.forward(req, resp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

	
}
