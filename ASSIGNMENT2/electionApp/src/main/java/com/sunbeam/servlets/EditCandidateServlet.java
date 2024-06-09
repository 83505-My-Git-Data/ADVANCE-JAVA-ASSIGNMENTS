package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		Candidate c = null;

		try (CandidateDao candDao = new CandidateDaoImpl()) {

			c = candDao.findById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit</title>");
		out.println("</head>");
		

		out.println("<body>");
		out.println("<form method ='post' action = 'editcand'>");
		out.printf("<input type ='hidden' name = 'id' value = '%d'/>\n</br></br>", c.getId());
		out.printf("Name: <input type ='text' name = 'name' value = '%s'/>\n</br></br>", c.getName());
		out.printf("Party: <input type ='text' name = 'party' value = '%s'/>\n</br></br>", c.getParty());
		out.printf("<input type ='hidden' name = 'votes' value = '%d'/>\n</br></br>", c.getVotes());
		out.println("<input type='submit' value='Update Candidate'/>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		String votesString = req.getParameter("votes");
		int votes = Integer.parseInt(votesString);
		
		Candidate c =new Candidate(id, name,party,votes); 
		try(CandidateDao candDao = new CandidateDaoImpl())
		{
			int count =  candDao.update(c);
			String msg = "Candidates Edited: " + count;
			req.setAttribute("message", msg);
			ServletContext ctx = this.getServletContext();
			RequestDispatcher rd = ctx.getRequestDispatcher("/result");
			rd.forward(req, resp);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException();
		}
		
		
	}

}
