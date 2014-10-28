package Utilities;

import java.util.List;
import java.util.UUID;

import Enum.StationEnum;
import Enum.TicketType;
import Models.SalesOrder;
import Models.Ticket;

/**
 * 实体创建工具类
 * 
 * @author qianyuanzhang
 *
 */
public class EntityCreator {

	private static int salesOrderId = 100000;
	private static int ticketId = 200000;

	/**
	 * 创建一个新的订单
	 * 
	 * @return
	 */
	public static SalesOrder create(String idCard, List<Ticket> tickets) {
		SalesOrder result = new SalesOrder();
		result.setCode(UUID.randomUUID().toString()); // 随机生成一个业务主键
		result.setIdCard(idCard);
		result.setTickets(tickets);

		return result;
	}

	/**
	 * 创建一个新的出票信息
	 * 
	 * @param toStation
	 *            目标车站
	 * @param carriageNumber
	 *            车厢号
	 * @param seatNumber
	 *            座位号
	 * @param idCard
	 *            身份证号
	 * @param isAvailable
	 *            是否有效
	 * @return
	 */
	public static Ticket create(StationEnum toStation, int carriageNumber,
			int seatNumber, String idCard, String ticketType,
			Boolean isAvailable) {
		Ticket result = new Ticket();
		result.setId(ticketId++); // 设定票的唯一主键
		result.setFromStation(CommonUtilities.getStation(StationEnum.Jinan)); // 起点站都是济南站
		result.setToStation(CommonUtilities.getStation(toStation));
		result.setIsAvailable(isAvailable);
		result.setIdCard(idCard);
		result.setTicketType(TicketType.valueOf(ticketType));
		result.setCarriageNumber(carriageNumber);
		result.setSeatNumber(seatNumber);
		result.setPrice(CommonUtilities.getPrice(toStation, idCard));

		return result;
	}
}
