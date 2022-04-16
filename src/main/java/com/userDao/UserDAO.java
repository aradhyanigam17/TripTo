package com.userDao;

import java.sql.*;

import com.classes.ContactTo;
import com.classes.Newsletter; 

public class UserDAO {
	public static Connection getConnection() {
		
		Connection con = null ; 
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tripto","root","root");// connected to database
			
			
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		return con ;
	}
	
	public static int saveData(ContactTo userContact)  {
		int status = 0 ;
		Connection connection = UserDAO.getConnection();
		
		try {
		PreparedStatement stmt = connection.prepareStatement("insert into contact(name , email , number , message) values(?,?,?,?)");
		
		stmt.setString(1,userContact.getName());
		stmt.setString(2,userContact.getEmail());
		stmt.setString(3,userContact.getNumber());
		stmt.setString(4,userContact.getMessage());
		
		status = stmt.executeUpdate() ; // this method is used to insert ,delete,update query 

		
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		return status ;
	}
	
	
	public int saveData(Newsletter newsletter) {
		
		int status = 0;
		
		Connection con = UserDAO.getConnection() ;
		
		
		try {
			PreparedStatement st = con.prepareStatement("insert into newsletter(email) value(?)");
			
			st.setString(1,newsletter.getEmail());
			status = st.executeUpdate() ;
			
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
		return status ;
	}
	
}
