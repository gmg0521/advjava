package Mini_Game_Heaven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mini_Game_Heaven.MemberDAO;
import Mini_Game_Heaven.WindowSetting;

public class game3 extends GameInterface implements KeyListener, WindowSetting {

	String id;
	boolean a = false;
	MemberDAO dao = new MemberDAO();

	private JPanel contentPane;

	boolean goal;

	ImageIcon finish = new ImageIcon(game3.class.getResource("/images/finish.png"));
	ImageIcon i_horse = new ImageIcon(game3.class.getResource("/images/horse.png"));
	ImageIcon i_flag = new ImageIcon(game3.class.getResource("/images/flag.png"));
	JLabel horse = new JLabel();
	JLabel flag = new JLabel();
	JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		new game3("unknown");
	}

	/**
	 * Create the frame.
	 * 
	 * @param id
	 */

	public game3(String id) {
		super("달려라! 경주마!", "Game3background");
		goal = false;
		this.id = id;
		setContentPane(getContentPane());
		setToCenter();
		setVisible(true);
		createUI();
		this.addKeyListener(this);

		requestFocus();
	}

	private void createUI() {
		horse.setBounds(5, 150, 50, 671);
		getContentPane().add(horse);
		horse.setIcon(i_horse);
		panel.setBounds(604, 5, 100, 671);

		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(flag, BorderLayout.CENTER);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 0, 0, 0));
		timeLabel.setText("0.000");
		panel.setBounds(800, 350, 150, 150);
		panel.add(timeLabel, BorderLayout.NORTH);
		timeLabel.setFont(new Font("굵은안상수체", Font.PLAIN, 40));
		timeLabel.setForeground(Color.BLACK);
		flag.setIcon(i_flag);

		ticticForGame3();

		this.addKeyListener(this);

	}

	private boolean isCrash() {
		return (horse.getX() >= panel.getX() - 30) ? true : false;
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
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_L:
			if (!goal)
				horse.setLocation(horse.getX() + 4, horse.getY());
			if (isCrash())
				horse.setEnabled(false);
			break;
		case KeyEvent.VK_SPACE:
			if (isCrash()) {
				this.addKeyListener(null);
				timer.cancel();
				goal = true;
				if (a == false) {
					a=!a;
					JOptionPane.showMessageDialog(null, "도착!");
					JOptionPane.showMessageDialog(null, "Score \n\n" + timeLabel.getText() + "!!!", "점수",
							EXIT_ON_CLOSE);
					if (dao.setScore(this.id, "game3", Double.parseDouble(timeLabel.getText()))) {
						new Menu(id, "IntroBackground");
						dispose();
					} else
						JOptionPane.showMessageDialog(this, "점수 저장 실패");
				}
			}
			break;
		}
	}

	@Override
	public void setToCenter() {
		Dimension frameSize = getSize();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

	}
}
