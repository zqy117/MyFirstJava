package Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据初始化类
 * @author qianyuanzhang
 *
 */
public class DataInitUtilites {
	/**
	 * 准备车站数据
	 * @return
	 */
	public static List<String> PreparingStationDatas() {
		List<String> result = new ArrayList<String>();
		String sql0 = "INSERT INTO train_station(ID, Code, Name)"
				+ " VALUES (10000001, 100, 'JiNan')";
		String sql1 = "INSERT INTO train_station(ID, Code, Name)"
				+ " VALUES (10000002, 101, 'TaiShan')";
		String sql2 = "INSERT INTO train_station(ID, Code, Name)"
				+ " VALUES (10000003, 102, 'XuZhou')";
		String sql3 = "INSERT INTO train_station(ID, Code, Name)"
				+ " VALUES (10000004, 103, 'NanJing')";
		String sql4 = "INSERT INTO train_station(ID, Code, Name)"
				+ " VALUES (10000005, 104, 'WuXi')";
		String sql5 = "INSERT INTO train_station(ID, Code, Name)"
				+ " VALUES (10000006, 105, 'ShangHai')";
		result.add(sql0);
		result.add(sql1);
		result.add(sql2);
		result.add(sql3);
		result.add(sql4);
		result.add(sql5);
		return result;
	}

	/**
	 * 准备车票数据
	 * @return
	 */
	public static List<String> PreparingTicketDatas(){
		List<String> result = new ArrayList<String>();
		
		// 各个车站出票数
		List<Integer> stationTickets = new ArrayList<Integer>();
		stationTickets.add(316);	// 上海站出票数量
		stationTickets.add(77);		// 无锡站出票数量
		stationTickets.add(292);	// 南京站出票数量
		stationTickets.add(195);	// 徐州站出票数量
		stationTickets.add(97);		// 泰山站出票数量
		// 各个车厢剩余票数
		List<Integer> carriageTickets = new ArrayList<Integer>();
		carriageTickets.add(98);	// 一车厢
		carriageTickets.add(99);	// 二车厢
		carriageTickets.add(100);	// 三车厢
		carriageTickets.add(98);	// 四车厢
		carriageTickets.add(96);	// 五车厢
		carriageTickets.add(97);	// 六车厢	
		carriageTickets.add(98);	// 七车厢
		carriageTickets.add(96);	// 八车厢
		carriageTickets.add(100);	// 九车厢
		carriageTickets.add(95);	// 十车厢
//		int carriage1 = 98;
//		int carriage2 = 99;
//		int carriage3 = 100;
//		int carriage4 = 98;
//		int carriage5 = 96;
//		int carriage6 = 97;
//		int carriage7 = 98;
//		int carriage8 = 96;
//		int carriage9 = 100;
//		int carriage10 = 95;
		
		int stationCount = 0;
		int ticketsCount = stationTickets.get(stationCount);
		int ticketId = 20000000;
		int toStationID = 10000006;
		int counter = 0;	// 计数器
		int carriageCounter = 0;
		String ticketSql = "INSERT INTO train_ticket(ID, ToStation,CarriageNumber,SeatNumber)"
				+ " VALUES (%d, %d, %d, %d)";	// 票数据添加的sql语句
		for (Integer carriageTicketCount : carriageTickets) {
			carriageCounter++;
			for (int i = 0; i < carriageTicketCount; i++) {
				if(counter == ticketsCount){
					//表示已经出完了一个车站的车票
					stationCount++;	// 下一个车站
					ticketsCount = stationTickets.indexOf(stationCount);	// 取出下个车站对应的车票数量
					counter = 0;	// 计数器归0
					toStationID--;	// 目的车站的主键减一
				}
				result.add(String.format(ticketSql, ticketId++, toStationID,
						carriageCounter, i + 1));
				counter++;
			}
		}
		
		return result;
	}
}
