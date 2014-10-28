package MyServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Ticket;
import Utilities.DataInitUtilites;
import Controler.TicketManager;
import DataBaseManager.DateBaseManager;



/**
 * Servlet implementation class SalesOrderServer
 */
@WebServlet("/SalesOrderServer")
public class SalesOrderServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalesOrderServer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		truncateTickets();
	}

	/**
	 * 删除所有车票信息
	 */
	private void truncateTickets() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");	// 传入的方法参数
		TicketManager ticketManager = new TicketManager();
		switch (action) {
		case "initTickets":
			try {
				List<Ticket> tickets = ticketManager.getAllTickets();
				request.getSession().setAttribute("tickets", tickets);
//				request.setAttribute("tickets", tickets);
				response.setHeader("Content-Type", "textml");
				getServletContext().getRequestDispatcher("/index.jsp").include(request,
						response);
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		
//		StringBuilder html = new StringBuilder();
//		html.append("<table class='resulttable' cellspacing=1 border=0>");
//		html.append("<tr>");
//		html.append("<td nowrap class='slicer'  nowrap='' colspan='1' rowspan='1'></td>");
//		html.append("<td class='columnheading' nowrap='' colspan='1'>Order Generated success!</td>");
//		html.append("</tr>");
//		html.append("</table>");
//		request.setAttribute("result", html.toString());
//		response.setHeader("Content-Type", "textml");
//		getServletContext().getRequestDispatcher("/index.jsp").include(request,
//				response);

	}

	

}
