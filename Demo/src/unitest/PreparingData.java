package unitest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;

import Models.SalesOrder;
import Utilities.DataInitUtilites;
import Controler.SalesOrderManager;
import DataBaseManager.DateBaseManager;

public class PreparingData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SalesOrderManager som = new SalesOrderManager();
		try {
			List<SalesOrder> result = som.querySalesOrder("371203");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateBaseManager dateBaseManager = new DateBaseManager();
//		List<String> stationSqls = PreparingStationDatas();
//		List<String> ticketSqls = DataInitUtilites.PreparingTicketDatas();
		String sql = "Select * from test.train_ticketSalesOrder where IDCard='371203' and IsEnable = '1';";
//		dateBaseManager.execute(stationSqls);	// 插入车站的相关数据
//		dateBaseManager.execute(ticketSqls);
		RowSet resultSet = dateBaseManager.query(sql);
		List<String> ticketNumbers = new ArrayList<String>();
		while (resultSet.next()) {
			ticketNumbers.add(resultSet.getString("ticketNumber"));
		}
	}

}
