package com.servlets;

import java.io.IOException;
import java.io.PrintWriter ;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.classes.Newsletter;
import com.userDao.UserDAO;
/**
 * Servlet implementation class NewsLetter
 */
public class NewsLetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsLetter() {
        super();
        // TODO Auto-generated constructor stub
    }

    UserDAO userdao;    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   public void init(ServletConfig config) throws ServletException{
	   userdao = new UserDAO() ;
   }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String email =  request.getParameter("email");
		
		PrintWriter out = response.getWriter();
		
		Newsletter newsletter = new Newsletter() ;
		
		newsletter.setEmail(email);
		
		int status = userdao.saveData(newsletter);
		
		if(status == 1) out.print("<h1>asjdfl;asjk</h1>");
		else out.print("<h1>Error</h1>") ;
		
	}

}
