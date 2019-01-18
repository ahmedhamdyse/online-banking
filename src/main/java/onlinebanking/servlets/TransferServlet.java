package onlinebanking.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinebanking.model.AccountModel;
import onlinebanking.service.AccountService;
import onlinebanking.service.ServiceFactory;

public class TransferServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long targetAccountNo = Long.parseLong(request.getParameter("targetAccountNo"));
		String password = request.getParameter("password");
		double transferAmount = Double.parseDouble(request.getParameter("amount"));

		AccountModel currentUserAccount = (AccountModel) request.getSession().getAttribute("userDetails");

		AccountService accountService = ServiceFactory.getAccountService();

		// Check current user password
		if (!accountService.correctPassword(currentUserAccount, password)) {
			request.setAttribute("notPassed", true);
			RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
			rd.forward(request, response);
		} else if (accountService.findAccount(targetAccountNo) == null) {

			// Check target account is exist
			request.setAttribute("targetAccountNotFound", true);
			RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
			rd.forward(request, response);

		} else {

			AccountModel accountModel = accountService.transfer(currentUserAccount.getAccount_no(), targetAccountNo,
					transferAmount);

			if (accountModel != null) {

				// Return json object
				response.getWriter()
						.write(new StringBuilder().append("{").append(" \"accountNumber\" : \" ")
								.append(accountModel.getAccount_no()).append("\"").append(",")
								.append(" \"currentAmount\" : \" ").append(accountModel.getAmount()).append("\"")
								.append("}").toString());
			} else {

				request.setAttribute("notEnoughMoney", true);
				RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
				rd.forward(request, response);
			}

		}

	}

}
