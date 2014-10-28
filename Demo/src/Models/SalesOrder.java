package Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table
public class SalesOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	//主键
	private String code;	// 业务主键，编码
	private Boolean isEnable;	// 订单是否有效
	private String idCard;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Ticket> tickets;	// 票，Key值为身份证号，value为该身份证买的票
	
	public SalesOrder() {
		// TODO Auto-generated constructor stub
		if(tickets == null)
			tickets = new ArrayList<Ticket>();
	}
	
	/**
	 * 订票函数
	 * @param idCard 身份证号
	 * @param bookedTicked 所要订的票
	 * @return 返回自身
	 */
 	public SalesOrder bookTicket(Ticket bookedTicked) {
 		tickets.add(bookedTicked);
 		return this;
	}  
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public int getId() {
		return id;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
