package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import model.Score;
import model.User;

public class ReadXMLDemo {
	
	private final SAXBuilder builder = new SAXBuilder();
	private File xmlFile;
	
	public void readPasswords() {
		  xmlFile = new File("passwords.xml");

		  try {

			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("score");

			for (int i = 0; i < list.size(); i++) {

			   Element node = (Element) list.get(i);
			   
			   //System.out.println(node.getAttribute("name").getValue());
			   //System.out.println(node.getAttribute("psw").getValue());
			   
			   ArrayList<Score> scoreUserList = readScores(node.getAttribute("name").getValue());
			   SnakeController.getInstance().getXmlController().fillUserList(new User(node.getAttribute("name").getValue(), node.getAttribute("psw").getValue(), scoreUserList));

			  
			}

		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
	}
	
	public ArrayList<Score> readScores(String name) {
		
		  xmlFile = new File("scores.xml");
		  ArrayList<Score> scoreList = new ArrayList<>();

		  try {

			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List list = rootNode.getChildren("score");

			for (int i = 0; i < list.size(); i++) {

			   Element node = (Element) list.get(i);
			   
			   if(name.equalsIgnoreCase(node.getAttribute("name").getValue())) {
				   scoreList.add(new Score(Integer.parseInt(node.getChildText("points")), node.getChildText("time")));
			   }
			   
			   //System.out.println(node.getAttribute("name").getValue());
			   //System.out.println("time : " + node.getChildText("time"));
			   //System.out.println("points : " + node.getChildText("points"));

			  
			}

		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
		  
		  return scoreList;
	}
	
	
	public void writeInPasswords(String name, String psw) {
		  xmlFile = new File("passwords.xml");
		  
		  try {

			Document document = (Document) builder.build(xmlFile);
			
			Element score = new Element("score");
			score.setAttribute(new Attribute("name", name));
			score.setAttribute(new Attribute("psw", psw));
			
			document.getRootElement().addContent(score);
			XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
			OutputStream outStream = new FileOutputStream(xmlFile);
			xmlOutputter.output(document, outStream);
			
				
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
	}
	
	public void writeInScores(String name, String uTime, String uPoints) {
		  File xmlFile = new File("scores.xml");
		  
		  try {

			Document document = (Document) builder.build(xmlFile);
			
			Element score = new Element("score");
			score.setAttribute(new Attribute("name", name));
			
			Element time = new Element("time");
			time.setText(uTime);
			Element points = new Element("points");
			points.setText(uPoints);
			
			score.addContent(time);
			score.addContent(points);

			document.getRootElement().addContent(score);
			
			XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
			OutputStream outStream = new FileOutputStream(xmlFile);
			xmlOutputter.output(document, outStream);
				
				
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
	}
}
