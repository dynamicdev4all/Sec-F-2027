package com.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.database.DatabaseConnection;
import com.app.util.JWTUtil;

/**
 * Servlet implementation class AccountVerify
 */
@WebServlet("/AccountVerify")
public class AccountVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String arg = request.getParameter("token");
		System.out.println("this is the JWT token :"+arg );
		String userEmail = JWTUtil.verifyJWT(arg);
		
		try {
			DatabaseConnection.verifyUser(userEmail);
			System.out.println("Account Verification Success");
		} catch (Exception e) {
			System.out.println("Account Verification Failed");
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
