package graphics;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import controller.SnakeController;
import model.Snake;

import java.awt.Color;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private LeftPanel leftPanel;
	private JPanel rightPanel;
	private JSplitPane splitPane;
	
	
	public MainPanel() {
		setBackground(Color.RED);
		setLayout(null);
		
		splitPane = new JSplitPane();
		splitPane.setBounds(6, 6, 920, 549);
		add(splitPane);
		
		splitPane.setDividerLocation(0.40);
		splitPane.setEnabled(false);
		
		
		leftPanel = new LeftPanel();
		splitPane.setLeftComponent(leftPanel);
		
		
		rightPanel = new LoginPanel();
		splitPane.setRightComponent(rightPanel);
		

	}


	public LeftPanel getLeftPanel() {
		return leftPanel;
	}


	public void setLeftPanel(LeftPanel leftPanel) {
		this.leftPanel = leftPanel;
	}


	public JPanel getRightPanel() {
		return rightPanel;
	}


	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}


	public JSplitPane getSplitPane() {
		return splitPane;
	}


	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}
	
	public void changeRightPanel(JPanel panel) {
		this.splitPane.remove(this.splitPane.getRightComponent());
		this.splitPane.setRightComponent(panel);
		this.splitPane.setDividerLocation(0.40);
		this.splitPane.getRightComponent().requestFocus();
		this.splitPane.revalidate();

	}
	
	public void changeLeftPanel(JPanel panel) {
		this.splitPane.remove(this.splitPane.getLeftComponent());
		this.splitPane.setLeftComponent(panel);;
		this.splitPane.setDividerLocation(0.40);
		this.splitPane.getLeftComponent().requestFocus();
		this.splitPane.revalidate();
	}
	

	
	
	
}
