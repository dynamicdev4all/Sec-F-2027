package com.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.database.DatabaseConnection;
import com.app.helper.EmailUtil;

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
		String mobileNum = request.getParameter("mobile");
		String emailAdd = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean dataInsertStatus = DatabaseConnection.insertUserData(firstName, lastName, Integer.parseInt(mobileNum), emailAdd, password);
		
		if(dataInsertStatus) {
			int OTP = (int)(Math.random() * 900000) + 100000;
			boolean OTPSentStatus = EmailUtil.sendRegisterOTP(emailAdd, firstName + " " + lastName, OTP);
			if(OTPSentStatus) {
				HttpSession session = request.getSession();
				session.setAttribute("sentOTP", OTP); 
				session.setAttribute("email", emailAdd); 
				response.sendRedirect("verify_otp_page.html");
			}else {
				System.out.println("OTP sent Failed");
			}
		}else {
			System.out.println("user data not saved in db");
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
