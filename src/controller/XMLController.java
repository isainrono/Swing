package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.SAXException;

import model.Score;
import model.User;

public class XMLController {
	
	private ArrayList<User> userList;
	//private final SnakeController MANAGER = SnakeController.getInstance();
	
	public XMLController() {
		xmlInit();
	}
	
	public void xmlInit() {
		this.userList = new ArrayList<User>();
		/*User isain = new User("isain", "1234");
		userList.add(isain);
		User camilo = new User("camilo", "1234");
		userList.add(camilo);
		User david = new User("david", "1234");
		userList.add(david);
		User angelly = new User("angelly", "1234");
		userList.add(angelly);
		User isain1 = new User("isain", "1234");
		userList.add(isain1);
		User camilo1 = new User("camilo", "1234");
		userList.add(camilo1);
		User david1 = new User("david", "1234");
		userList.add(david);
		User angelly1 = new User("angelly", "1234");
		userList.add(angelly1);
		User isain2 = new User("isain", "1234");
		userList.add(isain2);
		User camilo2 = new User("camilo", "1234");
		userList.add(camilo2);
		User david2 = new User("david", "1234");
		userList.add(david2);
		User angelly2 = new User("angelly", "1234");
		userList.add(angelly2);*/
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	
	private static Document getDOMParsedDocument(final String fileName) {
		Document document = null;
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			//factory.setNamespaceAware(true);
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
	        org.w3c.dom.Document w3cDocument = documentBuilder.parse(fileName);
	        document = new DOMBuilder().build(w3cDocument);
		} catch (IOException | SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return document;
	}
	

	public void fillUserList(User user) {
		// TODO Auto-generated method stub
		this.userList.add(new User(user.getName(), user.getPass(), user.getScoreList()));
		
	}
	
	
	public boolean checkLogin(String name, String pass) {
		
		for (int i = 0; i < SnakeController.getInstance().getXmlController().getUserList().size(); i++) {
		
			if(SnakeController.getInstance().getXmlController().getUserList().get(i).getName().equalsIgnoreCase(name)) {
				if(SnakeController.getInstance().getXmlController().getUserList().get(i).getPass().equalsIgnoreCase(pass)) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public boolean duplicateName(String name, String pass) {
		
		for (int i = 0; i < SnakeController.getInstance().getXmlController().getUserList().size(); i++) {
			
			if(SnakeController.getInstance().getXmlController().getUserList().get(i).getName().equalsIgnoreCase(name)) {
				return true;
			} else {
				new ReadXMLDemo().writeInPasswords(name, pass);
				return false;
			}
			
		}
		return false;
	}
	
	public User checkUser(String name) {
		
		for (int i = 0; i < this.userList.size(); i++) {
			if(this.userList.get(i).getName().equalsIgnoreCase(name)) {
				return this.userList.get(i);
			}
		}
		
		
		return new User(name, name, new ArrayList<Score>());
	}
	
	
	
	

}
