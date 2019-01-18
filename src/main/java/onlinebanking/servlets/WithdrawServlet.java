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

public class WithdrawServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		double withdrawAmount = Double.parseDouble(request.getParameter("amount"));
		String password = request.getParameter("password");

		AccountModel currentUserAccount = (AccountModel) request.getSession().getAttribute("userDetails");

		AccountService accountService = ServiceFactory.getAccountService();

		if (accountService.correctPassword(currentUserAccount, password)) {

			request.setAttribute("notPassed", false);

			AccountModel accountModel = accountService.withdraw(currentUserAccount.getAccount_no(), withdrawAmount);

			if (accountModel != null) {

				request.getSession().setAttribute("userDetails", accountModel);
				response.sendRedirect("Withdraw_process.jsp");
			} else {

				request.setAttribute("notEnoughMoney", true);
				RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
				rd.forward(request, response);
			}

		} else {

			request.setAttribute("notPassed", true);
			RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
			rd.forward(request, response);

		}

	}

}
