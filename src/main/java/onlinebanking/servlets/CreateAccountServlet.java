package onlinebanking.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinebanking.model.AccountModel;
import onlinebanking.service.AccountService;
import onlinebanking.service.ServiceFactory;

public class CreateAccountServlet extends HttpServlet {
	String account_no, first_name, last_name, address, city, branch, zip, username, password, re_password, phone_number,
			email, account_type;
	int amount;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		first_name = request.getParameter("first_name");
		last_name = request.getParameter("last_name");
		address = request.getParameter("address");
		city = request.getParameter("city");
		branch = request.getParameter("branch");
		zip = request.getParameter("zip");
		username = request.getParameter("username");
		password = request.getParameter("password");
		re_password = request.getParameter("re_password");
		phone_number = request.getParameter("phone");
		email = request.getParameter("email");
		account_type = request.getParameter("account_type");
		amount = Integer.parseInt(request.getParameter("amount"));

		// Getting Current date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String reg_date = df.format(new Date());

		// Setting all variables to model class
		AccountModel am = new AccountModel();
		am.setFirst_name(first_name);
		am.setLast_name(last_name);
		am.setAddress(address);
		am.setCity(city);
		am.setBranch(branch);
		am.setZip(zip);
		am.setUsername(username);
		am.setPassword(password);
		am.setPhone_number(phone_number);
		am.setEmail(email);
		am.setAccount_type(account_type);
		am.setAmount(amount);
		am.setReg_date(reg_date);

		if (password.equals(re_password)) {
			request.setAttribute("Account_details", am);

			AccountService accountService = ServiceFactory.getAccountService();
			accountService.createAccount(am);

			//request.setAttribute("account", am);

			// Update current account after deposit
			request.getSession().setAttribute("account", am);
			response.sendRedirect("create_account_progress.jsp");
			//rd.forward(request, response);

		} else {
			request.setAttribute("not_match", true);
			response.sendRedirect("create_account.jsp");
			//rd.forward(request, response);
		}
	}

}
