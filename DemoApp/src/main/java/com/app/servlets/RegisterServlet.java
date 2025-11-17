package com.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.app.database.DatabaseConnection;
import com.app.services.SendOTP;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobileNum = request.getParameter("mobileNum");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean saveDataStatus = DatabaseConnection.saveUserData(firstName, lastName, Integer.parseInt(mobileNum), email, password);
		
		if(saveDataStatus) {
			int OTP = (int) ((Math.random() * 900000) + 100000);	
			boolean OTPSendStatus = SendOTP.sendRegisterOTP(email, firstName + " " + lastName, OTP);
			if(OTPSendStatus){
				HttpSession session = request.getSession(); // new session create
				session.setAttribute("sentOTP", OTP);
				session.setAttribute("email", email);
				response.sendRedirect("verifyOTP.jsp");
			}else {
				System.out.println("OTP sent Failed");
			}
		}else {
			System.out.println("Data Save Failed");
		}
		
		
		
	
	}
;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
