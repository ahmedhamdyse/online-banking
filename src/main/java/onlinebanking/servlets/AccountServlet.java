package onlinebanking.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinebanking.model.AccountModel;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter()
				.append(new StringBuilder().append("{").append(" \"currentAmount\" : \" ")
						.append(((AccountModel) request.getSession().getAttribute("userDetails")).getAmount())
						.append("\"").append("}").toString());
	}

}
