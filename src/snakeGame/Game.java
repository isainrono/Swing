package snakeGame;

import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import controller.ReadXMLDemo;
import controller.SnakeController;
import graphics.MainView;
import model.Snake;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class Game{

	public static void main(String[] args) throws IOException {
		
		ReadXMLDemo xml = new ReadXMLDemo();
		xml.readPasswords();
		SnakeController.getInstance();
		
		
		
		
		
		//xml.writeInPasswords();
		//xml.writeInScores();
		
		
	}

}
