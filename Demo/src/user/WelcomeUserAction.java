package user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import Controler.SalesOrderManager;
import Models.SalesOrder;

import com.opensymphony.xwork2.ActionContext;

public class WelcomeUserAction{
	
	private SalesOrderManager som;	// salesOrderManager
	private static String pidCard;
	
	List<SalesOrder> soList;

	public List<SalesOrder> getSoList() {
		return soList;
	}


	public void setSoList(List<SalesOrder> soList) {
		this.soList = soList;
	}


	public WelcomeUserAction() {
		
		som = new SalesOrderManager();
	}
 
	private String idCard;
 

	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	// all struts logic here
	public String execute() {
		pidCard = idCard;
		return "SUCCESS";
		
	}
	
	public String findSalseOrder() throws ClassNotFoundException{
//		ActionContext context = ActionContext.getContext();		// 取出当前action的上下文
//		HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);	// 取出request和response
//		HttpServletResponse response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
//		Map session = context.getSession();
////		HttpSession se = request.getSession();
		try {
			setSoList(SalesOrderManager.querySalesOrder(pidCard));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILD";	// 失败
		}
		
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