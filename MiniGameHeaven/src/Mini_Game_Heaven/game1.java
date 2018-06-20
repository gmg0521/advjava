package Mini_Game_Heaven;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class game1 extends GameInterface implements KeyListener {
	String id;
	boolean a=false;
	MemberDAO dao = new MemberDAO();
	Font font = new Font("Gulim", Font.BOLD, 30);
	Random r = new Random();
	int combo = 0;
	int rand;
	int i1 = 0, i2 = 0, i3 = 0;
	int cursor = 1;
	boolean[] arrowcursor = { false, true, false };
	private JLabel t1, t2, t3, randLabel, score; // ?Öç?ä§?ä∏Ï∞ΩÏùÑ ?ëú?ãú?ïò?äî t1

	private ImageIcon Combo0 = new ImageIcon(Main.class.getResource("../images/Combo0.jpg"));
	private ImageIcon Combo1 = new ImageIcon(Main.class.getResource("../images/Combo1.jpg"));
	private ImageIcon Combo2 = new ImageIcon(Main.class.getResource("../images/Combo2.jpg"));
	private ImageIcon No = new ImageIcon(Main.class.getResource("../images/No.jpg"));
	private JLabel effect = new JLabel();
	private ImageIcon Arrow1 = new ImageIcon(Main.class.getResource("../images/πÿ¡Ÿ.png"));
	private JLabel arrow1 = new JLabel();
	private ImageIcon Arrow2 = new ImageIcon(Main.class.getResource("../images/πÿ¡Ÿ.png"));
	private JLabel arrow2 = new JLabel();
	private ImageIcon Arrow3 = new ImageIcon(Main.class.getResource("../images/πÿ¡Ÿ.png"));
	private JLabel arrow3 = new JLabel();
	private ImageIcon Lock = new ImageIcon(Main.class.getResource("../images/¿⁄π∞ºË±◊∏≤.png"));
	private JLabel lock = new JLabel();
	private JLabel lblScore = new JLabel("Score");
	private final JLabel lblNewLabel = new JLabel("! Passward !");

	public game1(String id) {
		super("jamul","Game1background");	
		JPanel sc = new JPanel();
		sc.setLayout(new GridLayout(2, 3));
		randLabel = new JLabel();
		randLabel.setBounds(42, 40, 136, 50);
		setRandLabel();
		getContentPane().setLayout(null);
		this.id=id;
		JPanel showRand = new JPanel();
		showRand.setBounds(392, 449, 236, 341);
		getContentPane().add(showRand);
		showRand.setBorder(new EmptyBorder(90, 100, 0, 0));
		showRand.setLayout(null);

		showRand.add(randLabel);
		randLabel.setHorizontalAlignment(SwingConstants.CENTER);
		randLabel.setBackground(new Color(255, 255, 255));
		randLabel.setFont(new Font("±Ω¿∫æ»ªÛºˆ√º", Font.BOLD, 60));
		randLabel.setForeground(Color.WHITE);
		t2 = new JLabel("0");
		t2.setBounds(488, 130, 90, 83);
		getContentPane().add(t2);
		t2.setForeground(Color.GREEN);
		t2.setFont(new Font("≥™¥Æ∞ÌµÒ", Font.BOLD, 99));
		arrow1.setHorizontalAlignment(SwingConstants.CENTER);
		arrow1.setBounds(359, 206, 50, 3);
		getContentPane().add(arrow1);
		arrow1.setIcon(new ImageIcon(game1.class.getResource("/images/\uBC11\uC904.PNG")));
		arrow1.setVisible(true);
		arrow2.setBounds(488, 206, 50, 3);
		getContentPane().add(arrow2);
		arrow2.setIcon(new ImageIcon(game1.class.getResource("/images/\uBC11\uC904.PNG")));
		arrow2.setHorizontalAlignment(SwingConstants.CENTER);
		arrow2.setFont(new Font("±Ω¿∫æ»ªÛºˆ√º", Font.BOLD, 12));
		arrow2.setVisible(false);
		arrow3.setLocation(620, 206);
		arrow3.setSize(50, 3);
		arrow3.setHorizontalAlignment(SwingConstants.CENTER);
		arrow3.setIcon(new ImageIcon(game1.class.getResource("/images/\uBC11\uC904.PNG")));
		getContentPane().add(arrow3);
		arrow3.setVisible(false);
		sc.setVisible(true);

		t1 = new JLabel("0");
		t1.setBounds(359, 130, 64, 83);
		getContentPane().add(t1);
		t1.setForeground(Color.RED);
		t1.setFont(new Font("≥™¥Æ∞ÌµÒ", Font.BOLD, 99));
		t3 = new JLabel("0");
		t3.setBounds(622, 130, 77, 83);
		getContentPane().add(t3);
		t3.setForeground(Color.BLUE);
		t3.setFont(new Font("≥™¥Æ∞ÌµÒ", Font.BOLD, 99));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(230, 341, 617, 124);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("OCR-B-10 BT", Font.PLAIN, 80));
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(826, 141, 186, 80);
		getContentPane().add(lblScore);
		lblScore.setFont(new Font("±Ω¿∫æ»ªÛºˆ√º", Font.BOLD | Font.ITALIC, 50));
		lock.setBounds(120, -15, 834, 346);
		getContentPane().add(lock);
		lock.setIcon(new ImageIcon(game1.class.getResource("/images/¿⁄π∞ºË±◊∏≤.png")));
		JPanel scorePanel = new JPanel();
		scorePanel.setBounds(708, 0, 236, 341);
		scorePanel.setLayout(null);
		getContentPane().add(scorePanel);
		effect.setBounds(0, 0, 236, 341);
		effect.setIcon(No);
		getContentPane().add(effect);
		effect.setVisible(false);

		lock.setVisible(true);

		
		scorePanel.setBackground(new Color(255,0,0,0));
		score = new JLabel("0");
		score.setForeground(Color.WHITE);
		score.setBounds(193, 213, 60, 60);
		scorePanel.add(score);
		score.setFont(new Font("±Ω¿∫æ»ªÛºˆ√º", Font.PLAIN, 40));
		score.setVisible(true);
		showRand.setBackground(new Color(255,0,0,0));
		
		JPanel timepanel = new JPanel();
		timepanel.setForeground(new Color(255, 255, 255));
		timepanel.setBackground(new Color(255,0,0,0));
		timepanel.setBounds(43, 341, 110, 90);
		getContentPane().add(timepanel);
		timepanel.add(timeLabel);
		timeLabel.setFont(new Font("±Ω¿∫æ»ªÛºˆ√º", Font.PLAIN, 40));
		timeLabel.setForeground(Color.WHITE);
		tictic();
		time.start();

		this.addKeyListener(this);
		
		requestFocus();
	}

	private void setRandLabel() {
		rand = r.nextInt(999);
		if (rand < 100) {
			if (rand < 10)
				randLabel.setText("00" + String.valueOf(rand));
			else
				randLabel.setText("0" + String.valueOf(rand));
		} else
			randLabel.setText(String.valueOf(rand));

	}

	Thread time = new Thread(new Runnable() {
		@Override
		public void run() {
			while (true) {
				if (Double.parseDouble(timeLabel.getText()) <= 3) {
					Music bonus = new Music("Bonus.mp3", false);
					bonus.start();
					break;
				}
			}
		}
	});

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (Double.parseDouble(timeLabel.getText()) > 0) {
			int key = e.getKeyCode();

			switch (key) {

			case KeyEvent.VK_RIGHT:
				Music shiftarrow = new Music("shiftarrow.mp3", false);
				shiftarrow.start();
				cursor++;
				if (cursor >= 4) {
					cursor = 1;
				}
				arrow1.setVisible(arrowcursor[(cursor) % 3]);
				arrow2.setVisible(arrowcursor[(cursor + 2) % 3]);
				arrow3.setVisible(arrowcursor[(cursor + 1) % 3]);
				break;
			case KeyEvent.VK_UP:
				Music shiftnumber = new Music("shiftnumber.mp3", false);
				shiftnumber.start();
				switch (cursor) {
				case 1:
					i1++;
					if (i1 >= 10)
						i1 = 0;
					t1.setText(String.valueOf(i1));
					break;
				case 2:
					i2++;
					if (i2 >= 10)
						i2 = 0;
					t2.setText(String.valueOf(i2));
					break;
				case 3:
					i3++;
					if (i3 >= 10)
						i3 = 0;
					t3.setText(String.valueOf(i3));
					break;
				}
				break;

			case KeyEvent.VK_ENTER:

				StringBuilder sb = new StringBuilder();
				sb.append(t1.getText()).append(t2.getText()).append(t3.getText());
				if (randLabel.getText().equals(sb.toString())) {
					if (combo == 0) {
						Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
						buttonClickedMusic.start();
						Thread c0 = new Thread(new Runnable() {
							public void run() {
								try {
									effect.setIcon(Combo0);
									effect.setVisible(true);
									combo++;
									score.setText(String.valueOf(Integer.parseInt(score.getText()) + 1));
									Thread.sleep(400);
									effect.setVisible(false);

								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						c0.start();

					} else if (combo == 1) {
						Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
						buttonClickedMusic.start();
						Thread c1 = new Thread(new Runnable() {
							public void run() {
								try {
									effect.setIcon(Combo1);
									effect.setVisible(true);
									combo++;
									score.setText(String.valueOf(Integer.parseInt(score.getText()) + 2));
									Thread.sleep(400);
									effect.setVisible(false);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						c1.start();
					} else {
						Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
						buttonClickedMusic.start();
						Thread c2 = new Thread(new Runnable() {
							public void run() {
								try {
									effect.setIcon(Combo2);
									effect.setVisible(true);
									score.setText(String.valueOf(Integer.parseInt(score.getText()) + 3));
									Thread.sleep(400);
									effect.setVisible(false);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						c2.start();
					}
				} else {
					combo = 0;
					Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
					buttonClickedMusic.start();
					Thread No = new Thread(new Runnable() {
						public void run() {
							try {
								ImageIcon No1 = new ImageIcon(Main.class.getResource("../images/No.jpg"));
								effect.setIcon(No1);
								effect.setVisible(true);
								Thread.sleep(400);
								effect.setVisible(false);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					});
					No.start();
				}
				setRandLabel();

			}
		}
		else
		{
			if (a == false) {
				a=!a;
				JOptionPane.showMessageDialog(null, "Score \n\n" + score.getText() + "!!!", "¡°ºˆ", EXIT_ON_CLOSE);
				if (dao.setScore(this.id, "game1", score.getText())) {
					new Menu(id, "IntroBackground");
					dispose();
				} else
					JOptionPane.showMessageDialog(this, "¡°ºˆ ¿˙¿Â Ω«∆–");
		}
	}
}}