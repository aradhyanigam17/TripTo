package com.servlets;

import java.io.IOException;
import com.userDao.UserDAO ;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.classes.ContactTo ;
import com.userDao.UserDAO;
/**
 * Servlet implementation class Contact
 */
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter() ;
		
		String name  = request.getParameter("name") ;
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String message = request.getParameter("message");
		
		ContactTo contact = new ContactTo() ;
		
		contact.setName(name);
		contact.setEmail(email);
		contact.setNumber(number);
		contact.setMessage(message) ;
		
		int status = UserDAO.saveData(contact) ;
		
		if(status == 1) {
			out.print("<h1>a;slfjkkas;lk</h1>");
		}
		else out.println("<h1>504 ERROR</h1>");
	}

}
