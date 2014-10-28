package user;

import java.util.List;

public class UserAction {
	private String name;
	private List<UserAction> list;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserAction> getList() {
		return list;
	}

	public void setList(List<UserAction> list) {
		this.list = list;
	}

	public String excute() {
		return "Hello";
	}
	
}
