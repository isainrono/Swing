package graphics;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.SnakeController;
import model.CustomListModel;
import model.User;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import org.omg.CORBA.portable.ValueOutputStream;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoresPanel extends JPanel {
	
	private final int B_WIDTH = 525;
    private final int B_HEIGHT = 525;
    private final CustomListModel list_model = new CustomListModel();
    private JTabbedPane tabbedPane;
    private JPanel usersList;
    private JTextField textField;
    
    // Panel de información de usuario
    private JLabel userName;
    private JLabel userBestScore;
    private JLabel userDate;
    private JLabel bestScore;
    
	/**
	 * Create the panel.
	 */
	public ScoresPanel() {
		initScoreBoard();
	}
	
	private void initScoreBoard() {
		setLayout(null);
		setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 121, 513, 375);
		add(tabbedPane);
		
	    // user List Window 
        userListWindow();
		
		JPanel bestUserScore = new JPanel();
		tabbedPane.addTab("Best Users Scores", null, bestUserScore, null);
		
		JPanel scoreFilter = new JPanel();
		tabbedPane.addTab("Score Filter", null, scoreFilter, null);
	}
	
	

	public CustomListModel getList_model() {
		return list_model;
	}
	
	public void userListWindow() {
		usersList = new JPanel();
		tabbedPane.addTab("Users List", null, usersList, null);
		usersList.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 107, 129, 184);
		usersList.add(scrollPane);
		
		JList<?> list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = list.locationToIndex(e.getPoint());
				userName.setText(SnakeController.getInstance().getUserAtPositionList(index).getName());
				System.out.println(SnakeController.getInstance().getUserList().get(index).getScoreList().size());
				//userBestScore.setText(String.valueOf(SnakeController.getInstance().getUserAtPositionList(index).getScoreList().size()));
				//userDate.setText(SnakeController.getInstance().getUserAtPositionList(index).getBestScoreDate());
			}
		});
		list.setModel(list_model);
		// no le gusta de esta manera la dejo asi para preguntar
		//this.list_model.setUserList(SnakeController.getInstance().getUserList());
		this.list_model.setUserList(SnakeController.getInstance().getUserList());
		scrollPane.setViewportView(list);
		
		textField = new JTextField();
		textField.setBounds(89, 59, 303, 36);
		usersList.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("...");
		button.setBounds(395, 59, 75, 34);
		usersList.add(button);
		
		JLabel lblFind = new JLabel("Find :");
		lblFind.setBounds(42, 69, 61, 16);
		usersList.add(lblFind);
		
		JPanel userScoreInfo = new JPanel();
		userScoreInfo.setBounds(176, 107, 288, 184);
		usersList.add(userScoreInfo);
		userScoreInfo.setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(38, 39, 61, 16);
		userScoreInfo.add(lblName);
		
		JLabel lblScores = new JLabel("Scores:");
		lblScores.setBounds(38, 65, 61, 16);
		userScoreInfo.add(lblScores);
		
		JLabel lblBestscore = new JLabel("BestScore:");
		lblBestscore.setBounds(38, 93, 86, 16);
		userScoreInfo.add(lblBestscore);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(38, 121, 61, 16);
		userScoreInfo.add(lblDate);
		

		userName = new JLabel("0");
		userName.setBounds(129, 39, 131, 16);
		userScoreInfo.add(userName);
		
		userBestScore = new JLabel("0");
		userBestScore.setBounds(129, 65, 123, 16);
		userScoreInfo.add(userBestScore);
		
		userDate = new JLabel("0");
		userDate.setBounds(129, 93, 115, 16);
		userScoreInfo.add(userDate);
		
		bestScore = new JLabel("0");
		bestScore.setBounds(129, 121, 61, 16);
		userScoreInfo.add(bestScore);

	}
}
