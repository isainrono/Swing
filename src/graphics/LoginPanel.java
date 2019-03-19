package graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.SnakeController;
import model.Snake;
import model.User;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	
	private JTextField user;
	private JTextField pass;
	private User validateUser;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		this.validateUser = new User("isain", "1234");
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
				if(validateUser.getName().equalsIgnoreCase(user.getText().toString()) && validateUser.getPass().equalsIgnoreCase(pass.getText().toString())) {
					
					System.out.println("cambia");
					
					
					JPanel menuPanel = new MenuPanel();
					SnakeController.getInstance().getFrame().getMainPanel().changeRightPanel(menuPanel);
					
				} else {
					JOptionPane.showMessageDialog(null, " Usuario o contraseña incorrecta");

				}
			}
		});
	}
	
	
}
