package Controler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.RowSet;

import org.springframework.stereotype.Component;

import DataBaseManager.DateBaseManager;
import Enum.StationEnum;
import Models.SalesOrder;
import Models.Ticket;
import Utilities.EntityCreator;

/**
 * 出票管理类
 * @author qianyuanzhang
 */

@Component
public class SalesOrderManager {
	
	/**
	 * 查询功能：
	 * 根据身份证号查询订单
	 * @param idCard 身份证号
	 * @return	该身份证下得订单
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static List<SalesOrder> querySalesOrder(String idCard)
			throws SQLException, ClassNotFoundException {
		TicketManager ticketManager = new TicketManager();
		List<SalesOrder> result = new ArrayList<SalesOrder>();
		List<String> ticketNumbers = new ArrayList<String>();

		String sql = "Select * from test.train_ticketSalesOrder where IDCard='"
				+ idCard + "'" + " and IsEnable = '1';"; // 查询
		RowSet resultSet = DateBaseManager.query(sql);
		while (resultSet.next()) {
			ticketNumbers.add(resultSet.getString("ticketNumber"));
		}

		List<Ticket> tickets = ticketManager.queryTicketsForNumber(ticketNumbers);
		SalesOrder ticket = EntityCreator.create(idCard, tickets); // 新建一个ticket的
		result.add(ticket);
		return result;
	}
	
	/**
	 * 插入功能：
	 * 向数据库中插入一条订单信息
	 * @param salesOrder 订单信息
	 * @return 插入成功返回true，失败返回false
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Boolean insertSalesOrder(SalesOrder salesOrder) throws ClassNotFoundException, SQLException{
		TicketManager ticketManager = new TicketManager();
		String soCode = UUID.randomUUID().toString();
//		String sql = "INSERT INTO test.train_ticketSalesOrder "
//				+ "(Code, IDCard, ticketNumber) " + "VALUES ( '"
//				+ soCode + "', 's%', 'd%');";	// 票据信息是通过数据库中查询出来的Enable为1 的最近的数据
		String sql = "INSERT INTO test.train_ticketSalesOrder "
				+ "(Code, IDCard, ticketNumber) " + "VALUES ( '"
				+ soCode + "', '";//s%', 'd%');";
		List<String> sqls = new ArrayList<String>();
		for (Ticket ticket : salesOrder.getTickets()) {
//			String tmpStr = String.format(sql,ticket.getIdCard(),			// 一直报错，找不到原因
//					+ ticket.getId());
			String tmpStr = sql + ticket.getIdCard()+"', '" + ticket.getId()+"');";
			sqls.add(tmpStr);
		}
		Object obj = new Object();
		Boolean result;
		synchronized (obj) {
			result = DateBaseManager.execute(sqls); // 插入订单数据
			if (result)
				result = ticketManager.updateTickets(salesOrder.getTickets()); // 更新票据信息
		}
		return result;
	}
	
	/**
	 * 更新功能：
	 * 向数据库中更新一条订单信息
	 * @param salesOrder 订单信息
	 * @return 插入成功返回true，失败返回false
	 */
	public static Boolean updateSalesOrder(SalesOrder salesOrder){
		return true;
	}
	
}