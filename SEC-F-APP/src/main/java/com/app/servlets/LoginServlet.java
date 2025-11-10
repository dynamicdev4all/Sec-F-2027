package com.app.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.database.DatabaseConnection;

import shadow.org.bson.Document;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailAdd = request.getParameter("email");
		String password = request.getParameter("password");

		Document loginUser =  DatabaseConnection.loginUser(emailAdd);
		if(loginUser != null) {
			if(emailAdd.equals(loginUser.getString("userEmail")) && password.equals(loginUser.getString("userPassword")) && loginUser.getBoolean("isVerified")) {
				HttpSession session = request.getSession();
				String name  = loginUser.getString("firstName") + " " + loginUser.getString("lastName");
				session.setAttribute("name", name); // data insert  or login
				response.sendRedirect("home.jsp");	
			}else if(emailAdd.equals(loginUser.getString("userEmail")) && password.equals(loginUser.getString("userPassword")) && !loginUser.getBoolean("isVerified")) {
				System.out.println("The account is not yet verified, please retry");
			}
			else {
				System.out.println("Your password is incorrect");
			}
		}else {
			System.out.println("User not registered, please try register first");
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
