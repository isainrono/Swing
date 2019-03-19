package graphics;

import javax.swing.JPanel;
import java.awt.Color;
import model.*;

public class RightPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RightPanel() {
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		
		Snake snake = new Snake();
	}

}
