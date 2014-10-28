package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Enum.TicketType;

/**
 * 车票类
 * @author qianyuanzhang
 *
 */

@Entity
@Table
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	// 主键
	
	@OneToOne
	@JoinColumn
	private Station fromStation;	// 起始车站编号
	
	@OneToOne
	@JoinColumn
	private Station toStation;	// 目标车站编号
	private int carriageNumber;	// 车厢号码
	private int seatNumber;	// 座位编码
	private String idCard;
	private int price;

	private TicketType ticketType;	// 车票类型
	private Boolean isAvailable;	//是否可以购买，如果已经订出去了表示不可以购买，为退票业务预留


	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getCarriageNumber() {
		return carriageNumber;
	}

	public void setCarriageNumber(int carriageNumber) {
		this.carriageNumber = carriageNumber;
	}

	public Station getToStation() {
		return toStation;
	}

	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}

	public Station getFromStation() {
		return fromStation;
	}

	public void setFromStation(Station fromStation) {
		this.fromStation = fromStation;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


}
