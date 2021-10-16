package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Gui extends JFrame {
	private JPanel panel;
	protected StartMenu start;
	protected SettingsMenu settings;
	protected GameScreen game;
	public Gui() {
		super("Connect 4");
		setSize(600 + 6, 600 + 35); //frame inset diff, //width = 600, height = 600
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setSize(600, 600);
		panel.setLayout(null);
		
		start = new StartMenu();
		settings = new SettingsMenu();
		
		panel.add(start);
		add(panel);
		setVisible(true);
	}
	
	public void swap(JLabel screen) {
		panel.removeAll();
		panel.add(screen);
		panel.repaint();
	}
	
	public void generateGame() {
		int tileWidth = 600 / settings.cellsWide; //int division :)
		int tileHeight = 600 / settings.cellsHigh; //int division :) 
		game = new GameScreen(settings.playerNum, settings.winCount, settings.playCount, settings.cellsWide, settings.cellsHigh, tileWidth, tileHeight);
		resizer(tileWidth * settings.cellsWide, tileHeight * settings.cellsHigh); //int division :) don't you love int division :)
	}
	
	public void resizer(int width, int height) {
		setSize(width + 6, height + 35);
		panel.setSize(width, height);
	}
}