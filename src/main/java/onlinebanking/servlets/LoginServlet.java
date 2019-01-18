package onlinebanking.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import onlinebanking.model.AccountModel;
import onlinebanking.service.LoginService;
import onlinebanking.service.ServiceFactory;

public class LoginServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("UserName");
		String password = request.getParameter("password");

		LoginService loginService = ServiceFactory.getLoginService();

		AccountModel am = loginService.login(userName, password);

		if (am == null) {

			request.setAttribute("isPassOK", "No");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		} else {
			// Setting Session variable for current User
			HttpSession session = request.getSession();
			session.setAttribute("userDetails", am);

			String[] remeberMe = request.getParameterValues("remember");

			if (remeberMe != null && remeberMe[0].equals("rememberMe")) {
				Cookie usercookie = new Cookie("userName", userName);
				Cookie passcookie = new Cookie("password", password);
				Cookie remcookie = new Cookie("rem", "checked");
				response.addCookie(usercookie);
				response.addCookie(passcookie);
				response.addCookie(remcookie);
			} else {
				Cookie usercookie = new Cookie("userName", null);
				usercookie.setMaxAge(0);
				Cookie passcookie = new Cookie("password", null);
				passcookie.setMaxAge(0);
				Cookie remcookie = new Cookie("rem", null);
				remcookie.setMaxAge(0);
				response.addCookie(usercookie);
				response.addCookie(passcookie);
				response.addCookie(remcookie);
			}

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}

}

