package Controler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.RowSet;

import DataBaseManager.DateBaseManager;
import Enum.StationEnum;
import Models.Ticket;
import Utilities.CommonUtilities;
import Utilities.EntityCreator;

public class TicketManager {

	/**
	 * 查询功能： 根据车厢号查询剩余的可定的车票数，用于查询是否有车票可被订
	 * 
	 * @param carriageNumber
	 *            车厢号
	 * @return 剩余的可被定得车票数
	 */
	public static int getAvaibleTicketsCount(int carriageNumber) {
		return 0;
	}

	/**
	 * 查询功能： 查询可被订的车票信息列表，用于显示车票信息
	 * 
	 * @param carriageNumber
	 *            车厢号
	 * @return 车票信息
	 */
	public List<Ticket> getAvaibleTickets(int carriageNumber) {
		List<Ticket> result = new ArrayList<Ticket>();
		return result;
	}

	/**
	 * 查询功能： 根据车站名称查询剩余的可定的车票数，用于查询是否有车票可被订
	 * 
	 * @param station
	 *            车站
	 * @return 剩余的可被定得车票数
	 */
	public int getAvaibleTicketsCount(StationEnum station) {
		return 0;
	}

	/**
	 * 查询功能： 查询可被订的车票信息列表，用于显示车票信息
	 * 
	 * @param station
	 *            车站
	 * @return 车票信息
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public List<Ticket> getAvaibleTickets(StationEnum station)
			throws SQLException, ClassNotFoundException {
		List<Ticket> result = new ArrayList<Ticket>();
		String queryString = "SELECT * " + "FROM test.train_ticket "
				+ "where ToStation = " + CommonUtilities.getStationPK(station)
				+ "and IsAvailable = 1;";
		RowSet resultSet = DateBaseManager.query(queryString);
		return createTickets(resultSet);
	}

	/**
	 * 获取全部可用的车票信息
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public List<Ticket> getAllTickets() throws SQLException, ClassNotFoundException {
		String queryString = "SELECT * " + "FROM test.train_ticket "
				+ "and IsAvailable = 1;";
		RowSet resultSet = DateBaseManager.query(queryString);

		return createTickets(resultSet);
	}

	/**
	 * 查询功能： 根据身份证号查询订到得票
	 * 
	 * @param idCard
	 *            身份证号
	 * @return 该身份证订的票
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public List<Ticket> queryTickets(String idCard) throws SQLException, ClassNotFoundException {
		String queryString = "SELECT * " + "FROM test.train_ticket "
				+ "where IDCard = " + idCard;

		RowSet resultSet = DateBaseManager.query(queryString);

		return createTickets(resultSet);

	}

	/**
	 * 查询功能： 根据身份证的列表获取对应的订票信息
	 * 
	 * @param idCards
	 *            身份证列表
	 * @return Key值是身份证号，Value值是对应的订票信息
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public List<Ticket> queryTickets(List<String> idCards) throws SQLException, ClassNotFoundException {
		// Map result = new HashMap<String, List<Ticket>>();
		StringBuilder sb = new StringBuilder();

		for (String idCard : idCards) {
			sb.append("'" + idCard + "',");
		}
		String ids = sb.toString().substring(0, sb.length() - 1); // 去掉最后一个，字符
		String sql = "SELECT * FROM test.train_ticket" + "WHERE IDCard IN ("
				+ ids + ")";
		RowSet resultSet = DateBaseManager.query(sql);
		return createTickets(resultSet);
		// return result;
	}

	/**
	 * 根据主键集合查询票
	 * TODO：可与上一个API抽象
	 * @param ticketNumbers
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public List<Ticket> queryTicketsForNumber(List<String> ticketNumbers) throws SQLException, ClassNotFoundException {
		StringBuilder sb = new StringBuilder();

		for (String ticketNumber : ticketNumbers) {
			sb.append(ticketNumber + ",");
		}
		String ids = sb.toString().substring(0, sb.length() - 1); // 去掉最后一个，字符
		String sql = "SELECT * FROM test.train_ticket" + " WHERE ID IN ("
				+ ids + ")";
		RowSet resultSet = DateBaseManager.query(sql);
		return createTickets(resultSet);
	}
	
	
	/**
	 * 更新出票信息列表
	 * 
	 * @param tickets
	 *            需要更新的出票信息
	 * @return 更新成功返回true，失败false
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Boolean updateTickets(List<Ticket> tickets) throws ClassNotFoundException, SQLException {
		
//		String sql = "UPDATE test.train_ticket SET IsAvailable='0', IDCard= 's%' WHERE ID= 's%';";	// 报错
		
		String sql = "UPDATE test.train_ticket SET IsAvailable='0', IDCard= '";//s%' WHERE ID= 's%';";
		List<String> sqls = new ArrayList<String>();
		
		for (Ticket ticket : tickets) {
			String temStr = sql+ticket.getIdCard()+"' WHERE ID= '"+ticket.getId()+"';";
//			sqls.add(String.format(sql, ticket.getId(), ticket.getIdCard()));	// format方法报错
			sqls.add(temStr);
		}
		return DateBaseManager.execute(sqls);	// 执行sql语句
	}

	/**
	 * 更新出票信息
	 * 
	 * @param ticket
	 *            需要更新的出票信息
	 * @return 更新成功返回true，失败false
	 */
	public Boolean updateTickets(Ticket ticket) {
		return true;
	}

	/**
	 * 根据查询结果生成票据集合
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private List<Ticket> createTickets(RowSet resultSet) throws SQLException {

		List<Ticket> result = new ArrayList<Ticket>();
		while (resultSet.next()) {

			Ticket ticket = EntityCreator.create(
					StationEnum.valueOf(resultSet.getInt("ToStation")),
					resultSet.getInt("CarriageNumber"),
					resultSet.getInt("SeatNumber"),
					resultSet.getString("IDCard"), 
					resultSet.getString("TicketType"), true); // 新建一个ticket的
			result.add(ticket);
		}
		return result;
	}
}
