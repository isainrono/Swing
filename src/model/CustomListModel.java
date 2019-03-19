package model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class CustomListModel extends AbstractListModel{
	
	private ArrayList<User> userList = new ArrayList<User>();

	@Override
	public int getSize() {
		return userList.size();
	}

	@Override
	public Object getElementAt(int index) {
		User user = userList.get(index);
		return user;
	}
	
	
	public void deleteUser(int index) {
		userList.remove(index);
		this.fireIntervalRemoved(this, getSize(), getSize()+1);
	}
	
	public User getUser(int index) {
		return userList.get(index);
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userList.add(user);
		this.fireIntervalAdded(this, getSize(), getSize()+1);
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	

}
