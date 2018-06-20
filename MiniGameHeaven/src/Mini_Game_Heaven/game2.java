package Mini_Game_Heaven;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class game2 extends GameInterface implements KeyListener {
	Random ran = new Random();
	String id;
	boolean a=false;
	MemberDAO dao = new MemberDAO();
	private ImageIcon Good = new ImageIcon(Main.class.getResource("../images/good.jpg"));
	private JLabel good = new JLabel();
	private ImageIcon Bad = new ImageIcon(Main.class.getResource("../images/bad.jpg"));
	private JLabel bad = new JLabel();

	private JTextField Zesia = new JTextField();
	private JTextField ipriak = new JTextField();
	private JLabel lblScore = new JLabel("Score");
	private JLabel scoreindex = new JLabel("0");

	int Score = 0;
	int i = 0;
	String[] zesi = { "hehehe", "what", "firEtRuck", "EsC", "StRawBerry", "KkKkkK", "XxXXXx", "OwO", "('-^)*",
			"(@)))))gimbap" };
	String[] F = { "f", "i", "n", "i", "s", "h" };

	public static void main(String[] args) {
		new game2("unknown");
	}

	public game2(String id) {
		super("charcharchar", "Game2background");
		//////////////////////////////////////////////////////////////////////////////
this.id=id;
		//////////////////////////////////////////////////////////////////////////////
		Zesia = new JTextField();
		Zesia.setBounds(380, 161, 269, 71);
		Zesia.setEditable(false);

		Zesia.setColumns(10);

		ipriak = new JTextField();
		ipriak.setBounds(459, 372, 116, 21);

		ipriak.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		bad.setBounds(774, 0, 250, 500);
		bad.setIcon(Bad);
		bad.setVisible(false);
		getContentPane().setLayout(null);
		getContentPane().add(ipriak);
		getContentPane().add(Zesia);
		lblScore.setBounds(426, 242, 237, 47);
		getContentPane().add(lblScore);
		scoreindex.setFont(new Font("굴림", Font.BOLD, 30));
		scoreindex.setBounds(488, 299, 78, 40);
		getContentPane().add(scoreindex);
		getContentPane().add(bad);

		ipriak.addKeyListener(this);

		Zesia.setText(zesi[ran.nextInt(8)]);

		lblScore.setFont(new Font("굴림", Font.BOLD, 50));
		getContentPane().add(lblScore);
		getContentPane().add(scoreindex);
		good.setBounds(0, 0, 1024, 500);
		getContentPane().add(good);
		good.setIcon(Good);
		this.addKeyListener(this);

		ipriak.requestFocus();
		
		JPanel timepanel = new JPanel();
		timepanel.setBounds(459, 510, 116, 124);
		timepanel.setForeground(Color.BLACK);
		timepanel.setBackground(new Color(255, 0, 0, 0));
		getContentPane().add(timepanel);
		timepanel.add(timeLabel);
		timepanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		good.setVisible(false);

		timeLabel.setFont(new Font("굵은안상수체", Font.PLAIN, 40));
		timeLabel.setForeground(Color.BLACK);
		tictic();
		time.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			Music cancel = new Music("지우기.mp3", false);
			cancel.start();
		}
	}

	Thread time = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {
				if (Double.parseDouble(timeLabel.getText()) <= 3) {
					Zesia.setText(F[i]);
					Music bonus = new Music("Bonus.mp3", false);
					bonus.start();
					break;
				}
			}
		}
	});

	public void keyReleased(KeyEvent e) {
		if (Double.parseDouble(timeLabel.getText()) > 0) {
			Music typing = new Music("키보드.mp3", false);
			typing.start();
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (Double.parseDouble(timeLabel.getText()) > 3) {
					/////////////////////////////////// 정답인 경우/////////////////
					if (ipriak.getText().equals(Zesia.getText())) {
						Thread c0 = new Thread(new Runnable() {
							public void run() {
								try {
									good.setVisible(true);
									Thread.sleep(600);
									good.setVisible(false);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						c0.start();
						Music correct = new Music("정답.mp3", false);
						correct.start();
						Score = Score + ipriak.getText().length();
						scoreindex.setText(String.valueOf(Score));
						Zesia.setText(zesi[ran.nextInt(10)]);
						ipriak.setText(null);
					}
					/////////////////////////////////// 여기까지 정답///////////////////

					else////////////////////////////// 오답인 경우/////////////////////
					{
						Thread c0 = new Thread(new Runnable() {
							public void run() {
								try {
									bad.setVisible(true);
									Thread.sleep(600);
									bad.setVisible(false);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						c0.start();
						Music wrong = new Music("오답.mp3", false);
						wrong.start();
						Zesia.setText(zesi[ran.nextInt(10)]);
					}
					/////////////////////////// 여기까지 오답///////////////////////
				} else {
					if (ipriak.getText().equals(Zesia.getText())) {
						Music finish = new Music("피니쉬.mp3", false);
						finish.start();
						Score = Score + 20 * ipriak.getText().length();
						scoreindex.setText(String.valueOf(Score));
						ipriak.setText(null);
						i++;
						if (i == 6) {
							i = 0;
						}
						Zesia.setText(F[i]);
					}
				}
			}
		}
		else
		{
			if (a == false) {
				a=!a;
				JOptionPane.showMessageDialog(null, "Score \n\n" + Score + "!!!", "점수", EXIT_ON_CLOSE);
				if (dao.setScore(this.id, "game2", Score)) {
					new Menu(id, "IntroBackground");
					dispose();
				} else
					JOptionPane.showMessageDialog(this, "점수 저장 실패");
			
		}
	}
}
}