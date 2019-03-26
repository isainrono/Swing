package graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.SnakeController;
import model.Score;
import model.Snake;
import model.User;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	
	private JTextField user;
	private JTextField pass;
	private User validateUser;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		
		this.validateUser = new User();
		setLayout(null);
		
		user = new JTextField();
		user.setBounds(119, 51, 298, 32);
		add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(119, 95, 298, 32);
		add(pass);
		
		JButton btnNewButton = new JButton("Login");		
		btnNewButton.setBounds(204, 157, 117, 29);
		add(btnNewButton);
		
		openUserOptions(btnNewButton);
	}

	public JTextField getUser() {
		return user;
	}

	public void setUser(JTextField user) {
		this.user = user;
	}

	public JTextField getPass() {
		return pass;
	}

	public void setPass(JTextField pass) {
		this.pass = pass;
	}
	
	public void openUserOptions(JButton btnNewButton) {
				
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(SnakeController.getInstance().getXmlController().checkLogin(user.getText().toString(), pass.getText().toString())) {
					
					welcome();

				} else {
					
					if(SnakeController.getInstance().getXmlController().duplicateName(user.getText().toString(), pass.getText().toString())) {
						SnakeController.getInstance().getFrame().getMainPanel().getLeftPanel().writeInConsole("Usuario o contraseña incorrecto");
					} else {
						welcome();
					}
					
				}
			}
		});
	}
	
	public void welcome() {
		SnakeController.getInstance().setUserLogged(SnakeController.getInstance().getXmlController().checkUser(user.getText().toString()));
		
		SnakeController.getInstance().getFrame().getMainPanel().getLeftPanel().writeInConsole("Login correcto");
		SnakeController.getInstance().getFrame().getMainPanel().getLeftPanel().writeInConsole("hola " + SnakeController.getInstance().getUserLogged().getName());
		JPanel menuPanel = new MenuPanel();
		SnakeController.getInstance().getFrame().getMainPanel().changeRightPanel(menuPanel);
	}
	
	
}
