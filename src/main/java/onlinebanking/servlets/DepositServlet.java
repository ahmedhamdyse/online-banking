package onlinebanking.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinebanking.model.AccountModel;
import onlinebanking.service.AccountService;
import onlinebanking.service.ServiceFactory;

public class DepositServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		double depositAmount = Double.parseDouble(request.getParameter("amount"));
		String password = request.getParameter("password");

		AccountModel currentUserAccount = (AccountModel) request.getSession().getAttribute("userDetails");

		AccountService accountService = ServiceFactory.getAccountService();

		if (accountService.correctPassword(currentUserAccount, password)) {

			currentUserAccount = accountService.deposit(currentUserAccount.getAccount_no(), depositAmount);

			// Update current account after deposit
			request.getSession().setAttribute("userDetails", currentUserAccount);

			response.sendRedirect("Deposit_process.jsp");

		} else {

			request.setAttribute("notPassed", true);
			RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
			rd.forward(request, response);

		}

	}

}
