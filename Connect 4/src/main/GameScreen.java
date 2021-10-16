package main;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class GameScreen extends JLabel {
	public ImageIcon empty; // val = 0
	public ImageIcon red; // val = 1
	public ImageIcon yellow; // val = 3
	public ImageIcon green; // val = 5
	public ImageIcon purple; // val = 7
	private ImageIcon hoverRed; // val = 2
	private ImageIcon hoverYellow; // val = 4
	private ImageIcon hoverGreen; // val = 6
	private ImageIcon hoverPurple; // val = 8

	private JLabel[][] iconBoard;
	private int[][] board;
	private final int numToWin;
	
	private int turn = 1;
	private final int numPlayers;
	
	private int numPlayedInTurn = 0;
	private final int playCount;

	public GameScreen(int playerNum, int winCount, int playCount, int cellsWide, int cellsHigh, int cellWidth,
			int cellHeight) {
		super();
		
		numToWin = winCount;
		numPlayers = playerNum;
		this.playCount = playCount;
		
		setSize(cellsWide * cellWidth, cellsHigh * cellHeight);
		setUpIcons(cellWidth, cellHeight);

		iconBoard = new JLabel[cellsHigh][cellsWide];
		board = new int[cellsHigh][cellsWide];
		for (int r = 0; r < iconBoard.length; r++) {
			for (int c = 0; c < (iconBoard[0]).length; c++) {
				board[r][c] = 0;
				iconBoard[r][c] = new JLabel(empty);
				iconBoard[r][c].setBounds(cellWidth * c, cellHeight * r, cellWidth, cellHeight);
				iconBoard[r][c].addMouseListener(new GameListener(c));
				add(iconBoard[r][c]);
			}
		}
	}

	private void setUpIcons(int cellWidth, int cellHeight) {
		empty = new ImageIcon((new ImageIcon(GameScreen.class.getResource("empty.png"))).getImage()
				.getScaledInstance(cellWidth, cellHeight, 4));
		red = new ImageIcon((new ImageIcon(GameScreen.class.getResource("red.png"))).getImage().getScaledInstance(cellWidth,
				cellHeight, 4));
		yellow = new ImageIcon((new ImageIcon(GameScreen.class.getResource("yellow.png"))).getImage()
				.getScaledInstance(cellWidth, cellHeight, 4));
		green = new ImageIcon((new ImageIcon(GameScreen.class.getResource("green.png"))).getImage()
				.getScaledInstance(cellWidth, cellHeight, 4));
		purple = new ImageIcon((new ImageIcon(GameScreen.class.getResource("purple.png"))).getImage()
				.getScaledInstance(cellWidth, cellHeight, 4));
		hoverRed = new ImageIcon((new ImageIcon(GameScreen.class.getResource("hoverR.png"))).getImage()
				.getScaledInstance(cellWidth, cellHeight, 4));
		hoverYellow = new ImageIcon((new ImageIcon(GameScreen.class.getResource("hoverY.png"))).getImage()
				.getScaledInstance(cellWidth, cellHeight, 4));
		hoverGreen = new ImageIcon((new ImageIcon(GameScreen.class.getResource("hoverG.png"))).getImage()
				.getScaledInstance(cellWidth, cellHeight, 4));
		hoverPurple = new ImageIcon((new ImageIcon(GameScreen.class.getResource("hoverP.png"))).getImage()
				.getScaledInstance(cellWidth, cellHeight, 4));
	}

	private class GameListener implements MouseListener {
		private int col;

		public GameListener(int column) {
			col = column;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// looping from bottom to top of grid
			for (int i = board.length - 1; i >= 0; i--) {
				if (board[i][col] == turn + 1) {
					board[i][col] = turn;
					iconBoard[i][col].setIcon(iconByValue(turn));
					
					checkAndPlayFullAnimation();
					if(Logic.checkWin(i, col, board, numToWin)) {
						winAnimation();
					}
					
					numPlayedInTurn++;
					if(numPlayedInTurn == playCount) {
						turn = (turn + 2) % (2 * numPlayers);
						numPlayedInTurn = 0;
					}
					mouseEntered(null);
					return;
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// looping from bottom to top of grid
			for (int i = board.length - 1; i >= 0; i--) {
				if (board[i][col] == 0) {
					board[i][col] = turn + 1;
					iconBoard[i][col].setIcon(iconByValue(turn + 1));
					return;
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// looping from bottom to top of grid
			for (int i = board.length - 1; i >= 0; i--) {
				if (board[i][col] == turn + 1) {
					board[i][col] = 0;
					iconBoard[i][col].setIcon(iconByValue(0));
				}
			}
		}

		// Not Used
		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
	}

	public ImageIcon iconByValue(int value) {
		switch (value) {
		case 0:
			return empty;
		case 1:
			return red;
		case 3:
			return yellow;
		case 5:
			return green;
		case 7:
			return purple;
		case 2:
			return hoverRed;
		case 4:
			return hoverYellow;
		case 6:
			return hoverGreen;
		case 8:
			return hoverPurple;
		default:
			return null;
		}
	}
	// someone wins
	public void winAnimation() {
		removeAll();
		setIcon(new ImageIcon(iconByValue(turn).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT)));
		addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {} 
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {} 
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.gui.resizer(600, 600);
				Main.gui.swap(Main.gui.start);
			}
		});
		repaint();
	}
	// board is full
	public void checkAndPlayFullAnimation() {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				if(board[r][c] == 0) {
					return;
				}
			}
		}
		//if it didn't return, therefore board is full
		removeAll();
		setIcon(new ImageIcon(GameScreen.class.getResource("sad.png")));
		addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {} 
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {} 
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.gui.resizer(600, 600);
				Main.gui.swap(Main.gui.start);
			}
		});
		repaint();
	}
}