package Utilities;

import Enum.StationEnum;
import Models.Station;

/**
 * 公共工具类
 * 
 * @author qianyuanzhang
 *
 */
public class CommonUtilities {

	/**
	 * 根据车站名称返回车站的主键
	 * 
	 * @param station
	 * @return
	 */
	public static int getStationPK(StationEnum station) {
		switch (station) {
		case Jinan:
			return 10000001;
		case TaiShan:
			return 10000002;
		case XuZhou:
			return 10000003;
		case NanJing:
			return 10000004;
		case WuXi:
			return 10000005;
		case ShangHai:
			return 10000006;
		default:
			return 10000001;
		}
	}

	/**
	 * 根据车站名称和身份证号返回票价
	 * 
	 * @param station 车站
	 * @param idCard	身份证号
	 * @return 最终计算的的价格
	 */
	public static int getPrice(StationEnum station, String idCard) {
		int childTicketPrice = 0;
		switch (station) {
		case TaiShan:
			if (!isChild(idCard, childTicketPrice, 15))
				return childTicketPrice;
			return 15;
		case XuZhou:
			if (!isChild(idCard, childTicketPrice, 50))
				return childTicketPrice;
			return 50;
		case NanJing:
			if (!isChild(idCard, childTicketPrice, 160))
				return childTicketPrice;
			return 160;
		case WuXi:
			if (!isChild(idCard, childTicketPrice, 220))
				return childTicketPrice;
			return 220;
		case ShangHai:
			if (!isChild(idCard, childTicketPrice, 280))
				return childTicketPrice;
			return 280;
		default:
			return 0;
		}
	}

	/**
	 * 是否是儿童票
	 * 
	 * @param idCard
	 *            身份证号
	 * @param childTicketPrice
	 *            儿童票价
	 * @param standardPrice
	 *            标准价格
	 * @return 如果是成人则返回false，如果是儿童则返回true的同时给儿童票赋值，如果是0-5岁票价为1元如果是5-10岁票价为标准价格的一半
	 */
	private static boolean isChild(String idCard, int childTicketPrice,
			int standardPrice) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 生成车站类
	 * @param toStation
	 * @return 车站的对象
	 */
	public static Station getStation(StationEnum toStation) {
		Station result = new Station();
		result.setName(toStation.toString());
		result.setId(CommonUtilities.getStationPK(toStation));
		result.setCode(CommonUtilities.getStationCode(toStation));
		return result;
	}

	/**
	 * 生成车站类
	 * @param pk_station 车站类的主键
	 * @return	车站的对象
	 */
	public static Station getStation(int pk_station) {
		Station result = new Station();
		result.setName(CommonUtilities.getStationEnum(pk_station).toString());
		result.setId(pk_station);
		result.setCode(CommonUtilities.getStationCode(StationEnum.valueOf(result.getName())));
		return result;
	}
	
	private static StationEnum getStationEnum(int pk_station) {
		// TODO Auto-generated method stub
		switch (pk_station) {
		case 10000001:
			return StationEnum.Jinan;
		case 10000002:
			return StationEnum.TaiShan;
		case 10000003:
			return StationEnum.XuZhou;
		case 10000004:
			return StationEnum.NanJing;
		case 10000005:
			return StationEnum.WuXi;
		case 10000006:
			return StationEnum.ShangHai;
		default:
			return StationEnum.Jinan;
		}
	}

	/**
	 * 获取车站的编号
	 * @param station
	 * @return
	 */
	private static int getStationCode(StationEnum station) {
		switch (station) {
		case Jinan:
			return 100;
		case TaiShan:
			return 101;
		case XuZhou:
			return 102;
		case NanJing:
			return 103;
		case WuXi:
			return 104;
		case ShangHai:
			return 105;
		default:
			return 100;
		}
	}
}
