package tw.eeit162.gameplat.model.javabean;

import java.io.Serializable;
import java.util.ArrayList;

public class ForManagerjspBean implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int totalPage;
	private ArrayList<UsersBean> users;
	
	
	
	public ForManagerjspBean() {
	}
	public ForManagerjspBean(int totalPage, ArrayList<UsersBean> users) {
		this.totalPage = totalPage;
		this.users = users;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public ArrayList<UsersBean> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<UsersBean> users) {
		this.users = users;
	}
	
	
}
