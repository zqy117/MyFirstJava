package user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import Controler.SalesOrderManager;
import Enum.StationEnum;
import Models.SalesOrder;
import Models.Ticket;
import Utilities.EntityCreator;

import com.opensymphony.xwork2.ActionContext;

public class BookTicketAction{
	
	private SalesOrderManager som;	// salesOrderManager


	// all struts logic here
	public String execute() throws ClassNotFoundException, SQLException {
		
		SalesOrderManager som = new SalesOrderManager();
		SalesOrder so =new SalesOrder();
		ActionContext context = ActionContext.getContext();		// 取出当前action的上下文
		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);	// 取出request和response
		HttpServletResponse response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
		Map session = context.getSession();
		HttpSession se = request.getSession();
		
		String[] tickets = request.getParameter("args").split(",");
		String soIdcard = request.getParameter("soIdcard");
		int carriageNumber = 1;
		int seatNumber = 4;
		so.setIdCard(soIdcard);
		int ticketNumber = 20000003;
		for (int i = 0; i < tickets.length; i += 2) {
			Ticket ticket = EntityCreator.create(
					StationEnum.valueOf(tickets[i]), carriageNumber,
					seatNumber, tickets[i+1], "HardSeat", true);
			ticket.setId(ticketNumber);
			ticketNumber++;
			seatNumber++;
			so.bookTicket(ticket);
		}
		
		if(!SalesOrderManager.insertSalesOrder(so))
			return "FAILD";
		
//		try {
//			request.getRequestDispatcher("/queryOrder.jsp").forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "SUCCESS";
		
	}
	
	
}