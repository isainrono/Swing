package graphics;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.SnakeController;
import model.CustomListModel;
import model.Score;
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
import javax.swing.JSlider;
import javax.swing.JSpinner;

public class ScoresPanel extends JPanel {
	
	private final int B_WIDTH = 525;
    private final int B_HEIGHT = 525;
    private final CustomListModel list_model = new CustomListModel();
    private final CustomListModel list_model2 = new CustomListModel();
    private JTabbedPane tabbedPane;
    private JPanel usersList;
    private JTextField textField;
    
    // Panel de información de usuario
    private JLabel userName;
    private JLabel scoreSize;
    private JLabel bestScore;
    private JLabel bestScoreDate;
    
    // best user Score information
    private JLabel name;
    private JLabel score;
    private JLabel date;
    
    // score Filter window
    private ArrayList<User> userScoreList;
    private JList<?> list2;
    private JScrollPane scrollPane;
    
    private final SnakeController MANAGER = SnakeController.getInstance();
    private JSpinner spinner;
    
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
		
		// best user Score
        bestUserScore();
		
		// score Filter
        scoreFilter();
		
		// backButton
		backButton();
		
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
				
				userName.setText(MANAGER.getUserAtPositionList(index).getName());
				scoreSize.setText(String.valueOf(MANAGER.getUserList().get(index).getScoreList().size()));
				bestScore.setText(String.valueOf(MANAGER.getUserList().get(index).getBestScore()));
				bestScoreDate.setText(MANAGER.getUserList().get(index).getBestScoreDate());
				
				
			}
		});
		list.setModel(list_model);
		// no le gusta de esta manera la dejo asi para preguntar
		//this.list_model.setUserList(SnakeController.getInstance().getUserList());
		//this.list_model.setUserList(SnakeController.getInstance().getUserList());
		this.list_model.setUserList(SnakeController.getInstance().getXmlController().getUserList());
		scrollPane.setViewportView(list);
		
		textField = new JTextField();
		textField.setBounds(89, 59, 303, 36);
		usersList.add(textField);
		textField.setColumns(10);
		
		JButton find = new JButton("...");
		find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(MANAGER.getFindUser(textField.getText()) == null) {
					System.out.println("ningun usuario con este nombre");
				} else {
					
					userName.setText(MANAGER.getFindUser(textField.getText()).getName());
					scoreSize.setText(String.valueOf(MANAGER.getFindUser(textField.getText()).getScoreList().size()));
					bestScore.setText(String.valueOf(MANAGER.getFindUser(textField.getText()).getBestScore()));
					bestScoreDate.setText(MANAGER.getFindUser(textField.getText()).getBestScoreDate());
				}
			}
		});
		
		find.setBounds(395, 59, 75, 34);
		usersList.add(find);
		
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
		userName.setBounds(129, 39, 153, 16);
		userScoreInfo.add(userName);
		
		scoreSize = new JLabel("0");
		scoreSize.setBounds(129, 65, 153, 16);
		userScoreInfo.add(scoreSize);
		
		bestScore = new JLabel("0");
		bestScore.setBounds(129, 93, 153, 16);
		userScoreInfo.add(bestScore);
		
		bestScoreDate = new JLabel("0");
		bestScoreDate.setBounds(129, 121, 153, 16);
		userScoreInfo.add(bestScoreDate);

	}
	
	public void bestUserScore() {
		JPanel bestUserScore = new JPanel();
		tabbedPane.addTab("Best Users Scores", null, bestUserScore, null);
		bestUserScore.setLayout(null);
		
		JLabel lblName_1 = new JLabel("Name: ");
		lblName_1.setBounds(91, 81, 61, 16);
		bestUserScore.add(lblName_1);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(91, 125, 61, 16);
		bestUserScore.add(lblScore);
		
		JLabel lblDate_1 = new JLabel("Date:");
		lblDate_1.setBounds(91, 176, 61, 16);
		bestUserScore.add(lblDate_1);
		
		name = new JLabel(MANAGER.getInstance().getBestScoreGame().getName());
		name.setBounds(164, 81, 284, 16);
		bestUserScore.add(name);
		
		score = new JLabel(String.valueOf(MANAGER.getInstance().getBestScoreGame().getBestScore()));
		score.setBounds(164, 125, 284, 16);
		bestUserScore.add(score);
		
		date = new JLabel(MANAGER.getBestScoreGame().getBestScoreDate());
		date.setBounds(164, 176, 284, 16);
		bestUserScore.add(date);
	}
	
	public void scoreFilter() {
		userScoreList = new ArrayList<User>();
		
		JPanel scoreFilter = new JPanel();
		tabbedPane.addTab("Score Filter", null, scoreFilter, null);
		scoreFilter.setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				userScoreList = MANAGER.getUserWithScore(spinner.getValue().hashCode());
				
				JList<?> listFind = new JList();
				listFind.setModel(list_model2);
				
				list_model2.setUserList(userScoreList);
				scrollPane.setViewportView(listFind);

				
			}
		});
		btnSearch.setBounds(346, 64, 117, 29);
		scoreFilter.add(btnSearch);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 121, 372, 168);
		scoreFilter.add(scrollPane);
		
		list2 = new JList();
		list2.setModel(list_model2);
		
		this.list_model2.setUserList(userScoreList);
		
		scrollPane.setViewportView(list2);
		
		spinner = new JSpinner();
		spinner.setBounds(54, 56, 282, 42);
		scoreFilter.add(spinner);
	}
	
	public void backButton() {
		JButton button = new JButton("<--");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPanel panel = new MenuPanel();
				SnakeController.getInstance().getFrame().getMainPanel().changeRightPanel(panel);
			}
		});
		button.setBounds(22, 36, 89, 29);
		add(button);
	}
}
