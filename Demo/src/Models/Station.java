package Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Enum.StationEnum;

/**
 * 车站类
 * @author qianyuanzhang
 *
 */

@Entity
@Table
public class Station {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	// 主键
	private int code;	// 编号，业务主键
	private String name;	// 车站类型

	public String getName() {
		return name;
	}

	public void setName(String station) {
		name = station;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
