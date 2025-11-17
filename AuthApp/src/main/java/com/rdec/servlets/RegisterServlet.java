package com.rdec.servlets;

import java.io.IOException;

import com.rdec.config.SecretReader;
import com.rdec.database.DatabaseConnection;
import com.rdec.helper.EmailOTP;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		String firstName = request.getParameter("fName_key");
		String lastName = request.getParameter("lName_key");
		String mobileNum = request.getParameter("mob_key");
		String email = request.getParameter("email_key");
		String password = request.getParameter("password_key");
		
		boolean insertDataStatus = DatabaseConnection.insertUserData(firstName, lastName, Integer.parseInt(mobileNum), email, password);
		
		if(insertDataStatus) {
			int O = (int)(Math.random() * 900000)+100000;
			boolean OTPSentStatus = EmailOTP.sendRegisterOTP(email, firstName + " " + lastName, O);
			if(OTPSentStatus) { //this value is true if OTP is sent successfully else the value will be false.
				HttpSession session = request.getSession();
				session.setAttribute("sentOTP_key", O);
				session.setAttribute("userEmail", email);
				response.sendRedirect("verify_otp_page.jsp");
			}else {
				System.out.println("OTP sent failed");
				System.out.println(SecretReader.readSecrets("ERROR", "hi", "IN"));
			}
		}else {
			System.out.println("Data not Saved");
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
