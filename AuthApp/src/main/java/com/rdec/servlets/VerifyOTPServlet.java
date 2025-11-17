package com.rdec.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.rdec.database.DatabaseConnection;

/**
 * Servlet implementation class VerifyOTPServlet
 */
@WebServlet("/VerifyOTPServlet")
public class VerifyOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyOTPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enteredOTP = request.getParameter("enteredOTP");
		//HttpSession session = request.getSession(); //this creates a new session
		HttpSession session = request.getSession(false); //this does not create a new session but returns the old one
		int sentOTP =(int)(session.getAttribute("sentOTP_key"));
		String userEmail =(String)(session.getAttribute("userEmail"));
		String userPhone =(String)(session.getAttribute("userPhone"));
		
		if(Integer.parseInt(enteredOTP)== sentOTP) {
			DatabaseConnection.verifyUser(userEmail);
		}else {
			System.out.println("OTP verification failed");
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
