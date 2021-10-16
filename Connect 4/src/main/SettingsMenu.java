package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SettingsMenu extends JLabel {
	public int playerNum = 2;
	public int winCount = 4;
	public int playCount = 1;
	public int cellsWide = 10;
	public int cellsHigh = 10;

	private JSlider playerNumSlider;
	private JSlider winCountSlider;
	private JSlider playCountSlider;
	private JSlider cellsWideSlider;
	private JSlider cellsHighSlider;

	private JLabel playerNumDisplay;
	private JLabel winCountDisplay;
	private JLabel playCountDisplay;
	private JLabel cellsWideDisplay;
	private JLabel cellsHighDisplay;

	private JButton ok;

	public SettingsMenu() {
		super();
		setSize(600, 600);
		setOpaque(true);
		setBackground(Color.BLACK);

		setUpPlayerNum();
		setUpWinCount();
		setUpPlayCount();
		setUpCellsWide();
		setUpCellsHigh();
		
		ok = new JButton("Ok");
		ok.setBounds(250, 510, 100, 50);
		ok.setFocusable(false);
		ok.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
		ok.setBackground(Color.BLACK);
		ok.setForeground(Color.YELLOW);
		ok.setFont(new Font(this.getFont().getName(), Font.PLAIN, 40));
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gui.swap(Main.gui.start);

			}
		});
		add(ok);
	}

	private void setUpPlayerNum() {
		// Number of Players
		playerNumSlider = new JSlider(0, 2, 4, playerNum);
		playerNumSlider.setBounds(150, 50, 300, 50);
		playerNumSlider.setToolTipText("How many players?");
		playerNumSlider.setBackground(Color.YELLOW);
		playerNumSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				playerNum = playerNumSlider.getValue();
				playerNumDisplay.setText(playerNum + " players");
			}
		});
		add(playerNumSlider);

		playerNumDisplay = new JLabel(playerNum + " players");
		playerNumDisplay.setFont(new Font(getFont().getName(), Font.PLAIN, 40));
		playerNumDisplay.setForeground(Color.YELLOW);
		playerNumDisplay.setBounds(150, 5, 300, 40);
		add(playerNumDisplay);
	}

	private void setUpWinCount() {
		// Number needed to win
		winCountSlider = new JSlider(0, 3, 10, winCount);
		winCountSlider.setBounds(150, 150, 300, 50);
		winCountSlider.setToolTipText("How much pieces in a row do you want to need to win?");
		winCountSlider.setBackground(Color.YELLOW);
		winCountSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				winCount = winCountSlider.getValue();
				winCountDisplay.setText(winCount + " pieces in a row to win");
			}
		});
		add(winCountSlider);

		winCountDisplay = new JLabel(winCount + " pieces in a row to win");
		winCountDisplay.setFont(new Font(getFont().getName(), Font.PLAIN, 27));
		winCountDisplay.setForeground(Color.YELLOW);
		winCountDisplay.setBounds(150, 105, 300, 40);
		add(winCountDisplay);
	}

	private void setUpPlayCount() {
		// Number of tiles played per turn
		playCountSlider = new JSlider(0, 1, 3, playCount);
		playCountSlider.setBounds(150, 250, 300, 50);
		playCountSlider.setToolTipText("How many pieces do you want each player to play in 1 turn?");
		playCountSlider.setBackground(Color.YELLOW);
		playCountSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				playCount = playCountSlider.getValue();
				playCountDisplay.setText(playCount + " piece" + (playCount == 1 ? "" : "s") + " played per turn");
			}
		});
		add(playCountSlider);

		playCountDisplay = new JLabel(playCount + " piece played per turn");
		playCountDisplay.setFont(new Font(getFont().getName(), Font.PLAIN, 27));
		playCountDisplay.setForeground(Color.YELLOW);
		playCountDisplay.setBounds(150, 205, 300, 40);
		add(playCountDisplay);
	}

	private void setUpCellsWide() {
		// Number of cells wide
		cellsWideSlider = new JSlider(0, 7, 20, cellsWide);
		cellsWideSlider.setBounds(150, 350, 300, 50);
		cellsWideSlider.setToolTipText("Width of the playfield");
		cellsWideSlider.setBackground(Color.YELLOW);
		cellsWideSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cellsWide = cellsWideSlider.getValue();
				cellsWideDisplay.setText(cellsWide + " cells wide");
			}
		});
		add(cellsWideSlider);

		cellsWideDisplay = new JLabel(cellsWide + " cells wide");
		cellsWideDisplay.setFont(new Font(getFont().getName(), Font.PLAIN, 27));
		cellsWideDisplay.setForeground(Color.YELLOW);
		cellsWideDisplay.setBounds(150, 305, 300, 40);
		add(cellsWideDisplay);
	}

	private void setUpCellsHigh() {
		// Number of cells tall
		cellsHighSlider = new JSlider(0, 7, 20, cellsHigh);
		cellsHighSlider.setBounds(150, 450, 300, 50);
		cellsHighSlider.setToolTipText("cellsHigh of the playfield");
		cellsHighSlider.setBackground(Color.YELLOW);
		cellsHighSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cellsHigh = cellsHighSlider.getValue();
				cellsHighDisplay.setText(cellsHigh + " cells tall");
			}
		});
		add(cellsHighSlider);

		cellsHighDisplay = new JLabel(cellsHigh + " cells tall");
		cellsHighDisplay.setFont(new Font(getFont().getName(), Font.PLAIN, 27));
		cellsHighDisplay.setForeground(Color.YELLOW);
		cellsHighDisplay.setBounds(150, 405, 300, 40);
		add(cellsHighDisplay);
	}
}