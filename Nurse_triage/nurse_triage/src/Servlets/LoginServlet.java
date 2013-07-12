package Servlets;

import java.io.IOException;

import javaclasses.CheckLogin;
import javaclasses.LoginPojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



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
		
			System.out.println("BEAN IS NOT SET");
			try 
			{ 
			LoginPojo user = new LoginPojo(); 
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password")); 
			System.out.println("BEAN IS SET");
			String loginresult = CheckLogin.checklogin(user);
			System.out.println("Login result is:" + loginresult);
			if (!loginresult.isEmpty()) 
			{ 
			HttpSession session = request.getSession(true);
			session.setAttribute("user",user); 
			session.setAttribute("group",loginresult); 
			response.sendRedirect("RetrieveList"); //logged-in page 
			} 
			else 
				response.sendRedirect("LoginPage.jsp"); //error page 
			} 
			
			catch (Throwable theException) 
			{ 
				System.out.println(theException); 
			}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
