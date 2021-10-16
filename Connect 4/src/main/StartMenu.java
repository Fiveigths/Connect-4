package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class StartMenu extends JLabel {
	private JButton play;
	private JButton settings;
	private JButton exit;
	
	public StartMenu() {
		super();
		setIcon(new ImageIcon(StartMenu.class.getResource("start.png")));
		setSize(600, 600);
		
		play = new JButton("Play");
		play.setBounds(150, 170, 300, 100);
		play.setFocusable(false);
		play.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
		play.setBackground(Color.BLACK);
		play.setForeground(Color.YELLOW);
		play.setFont(new Font(this.getFont().getName(), Font.PLAIN, 60));
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gui.generateGame();
				Main.gui.swap(Main.gui.game);
			}
		});
		add(play);
		
		settings = new JButton("Settings");
		settings.setBounds(150, 320, 300, 100);
		settings.setFocusable(false);
		settings.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
		settings.setBackground(Color.BLACK);
		settings.setForeground(Color.YELLOW);
		settings.setFont(new Font(this.getFont().getName(), Font.PLAIN, 60));
		settings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gui.swap(Main.gui.settings);
			}
		});
		add(settings);
		
		exit = new JButton("Exit");
		exit.setBounds(150, 470, 300, 100);
		exit.setFocusable(false);
		exit.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.YELLOW);
		exit.setFont(new Font(this.getFont().getName(), Font.PLAIN, 60));
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(exit);
	}
}