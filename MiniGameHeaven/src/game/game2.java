package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class game2 extends JFrame implements KeyListener{
	
	GameInterface game = new GameInterface();

	private JPanel contentPane;
	
	static boolean goal = false;
	
	ImageIcon finish = new ImageIcon(game2.class.getResource("/images/finish.png"));
	ImageIcon i_horse = new ImageIcon(game2.class.getResource("/images/horse.png"));
	ImageIcon i_flag = new ImageIcon(game2.class.getResource("/images/flag.png"));
	JLabel horse = new JLabel();
	JLabel flag = new JLabel();
	JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
		
	
	public static void main(String[] args){
		new game2();
	}


	/**
	 * Create the frame.
	 */
	
	public game2() {
		super("달려라! 경주마!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 0));
		setContentPane(contentPane);		
		setVisible(true);
		
		createUI();
	}

	private void createUI() {
		contentPane.setLayout(null);
		horse.setBounds(5, 5, 50, 671);
		contentPane.add(horse);
		horse.setIcon(i_horse);
		panel.setBounds(604, 5, 100, 671);
		
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(flag, BorderLayout.CENTER);
		panel.add(game.timeLabel, BorderLayout.NORTH);
		flag.setIcon(i_flag);
		this.addKeyListener(this);
		
		tictic();
		
	}


	private void tictic() {
		game.timer.scheduleAtFixedRate(game.task, game.delay, game.intervalPeriod);
		
	}


	private boolean isCrash() {
		return (horse.getX() >= panel.getX()-30) ? true : false;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_L:
			if(!goal)
				horse.setLocation(horse.getX()+4, horse.getY());
			if(isCrash())
				horse.setEnabled(false);
			break;
		case KeyEvent.VK_SPACE:
			if(isCrash()) {
				game.timer.cancel();
				goal = true;
				JOptionPane.showMessageDialog(null, "도착!", "HollY!", JFrame.EXIT_ON_CLOSE);
			}
			break;
			
		}
	}
}
