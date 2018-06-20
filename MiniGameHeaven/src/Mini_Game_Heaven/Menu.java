package Mini_Game_Heaven;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Mini_Game_Heaven.Rank;
import Mini_Game_Heaven.WindowSetting;

public class Menu extends BackGround implements WindowSetting {

	private String id;

	private Image screenImage;
	private Graphics screenGraphics;

	private Image blink = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();

	private ImageIcon rankEnterImage = new ImageIcon(Main.class.getResource("../images/rank_enter.png"));
	private ImageIcon rankBasicImage = new ImageIcon(Main.class.getResource("../images/rank_basic.PNG"));
	private JButton rankButton = new JButton(rankBasicImage);

	private ImageIcon TitleButtonEnterImage = new ImageIcon(Main.class.getResource("../images/TitleButtonEnter.png"));
	private ImageIcon TitleButtonBasicImage = new ImageIcon(Main.class.getResource("../images/TitleButtonBasic.png"));
	private JButton TitleButton = new JButton(TitleButtonBasicImage);

	private ImageIcon playButtonEnterImage1 = new ImageIcon(Main.class.getResource("../images/play1_enter.png"));
	private ImageIcon playButtonBasicImage1 = new ImageIcon(Main.class.getResource("../images/play1_basic.png"));
	private JButton playButton1 = new JButton(playButtonBasicImage1);

	private ImageIcon playButtonEnterImage2 = new ImageIcon(Main.class.getResource("../images/play2_enter.png"));
	private ImageIcon playButtonBasicImage2 = new ImageIcon(Main.class.getResource("../images/play2_basic.png"));
	private JButton playButton2 = new JButton(playButtonBasicImage2);

	private ImageIcon playButtonEnterImage3 = new ImageIcon(Main.class.getResource("../images/play3_enter.png"));
	private ImageIcon playButtonBasicImage3 = new ImageIcon(Main.class.getResource("../images/play3_basic.png"));
	private JButton playButton3 = new JButton(playButtonBasicImage3);

	private ImageIcon playButtonEnterImage4 = new ImageIcon(Main.class.getResource("../images/play4_enter.png"));
	private ImageIcon playButtonBasicImage4 = new ImageIcon(Main.class.getResource("../images/play4_basic.png"));
	private JButton playButton4 = new JButton(playButtonBasicImage4);

	private ImageIcon playButtonEnterImage5 = new ImageIcon(Main.class.getResource("../images/play5_basic.jpg"));
	private ImageIcon playButtonBasicImage5 = new ImageIcon(Main.class.getResource("../images/play5_basic.jpg"));
	private JButton playButton5 = new JButton(playButtonBasicImage5);

	private JButton rank = new JButton("RANK");

	public Menu(String id, String s2) {
		super(id, s2);
		this.id = id;
		setTitle("GAME");

		TitleButton.setBounds(900, 566, 150, 150);
		TitleButton.setBorderPainted(false);
		TitleButton.setContentAreaFilled(false);
		TitleButton.setFocusPainted(false);

		playButton1.setBounds(50, 300, 100, 100);
		playButton1.setBorderPainted(false);
		playButton1.setContentAreaFilled(false);
		playButton1.setFocusPainted(false);
		playButton1.setVisible(true);

		playButton2.setBounds(330, 300, 134, 134);
		playButton2.setBorderPainted(false);
		playButton2.setContentAreaFilled(false);
		playButton2.setFocusPainted(false);
		playButton2.setVisible(false);

		playButton3.setBounds(100, 300, 134, 134);
		playButton3.setBorderPainted(false);
		playButton3.setContentAreaFilled(false);
		playButton3.setFocusPainted(false);
		playButton3.setVisible(false);

		playButton4.setBounds(580, 300, 134, 134);
		playButton4.setSize(134, 134);
		playButton4.setBorderPainted(false);
		playButton4.setContentAreaFilled(false);
		playButton4.setFocusPainted(false);
		playButton4.setVisible(false);

		playButton5.setBounds(800, 300, 134, 134);
		Image playButton5_2 = playButtonEnterImage5.getImage();
		playButton5_2 = playButton5_2.getScaledInstance(134, 134, Image.SCALE_SMOOTH);
		ImageIcon new5Icon = new ImageIcon(playButton5_2);
		playButton5.setIcon(new5Icon);
		playButton5.setSize(134, 134);
		playButton5.setBorderPainted(false);
		playButton5.setContentAreaFilled(false);
		playButton5.setFocusPainted(false);
		playButton5.setVisible(false);

		rankButton.setBounds(530, 500, 134, 134);
		rankButton.setSize(134, 134);
		rankButton.setBorderPainted(false);
		rankButton.setContentAreaFilled(false);
		rankButton.setFocusPainted(false);
		rankButton.setVisible(false);

		playButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton1.setIcon(playButtonEnterImage1);
				playButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playButton1.setIcon(playButtonBasicImage1);
				playButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
				buttonClickedMusic.start();
				try {

					Thread.sleep(800);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				playButton1.setVisible(false);
				playButton2.setVisible(true);
				playButton3.setVisible(true);
				playButton4.setVisible(true);
				playButton5.setVisible(true);
				rankButton.setVisible(true);

				IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png")).getImage();
			}
		});
		add(playButton1);

		playButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton2.setIcon(playButtonEnterImage2);
				playButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playButton2.setIcon(playButtonBasicImage2);
				playButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
				buttonClickedMusic.start();

				Thread blink = new Thread(new Runnable() {
					public void run() {
						IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
						try {
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png"))
									.getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png"))
									.getImage();
							Thread.sleep(500);
							playgamestart(e);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				});
				blink.start();
			}
		});
		add(playButton2);
	
		playButton3.addMouseListener(new MouseAdapter()// 열어라 자물쇠
		{
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton3.setIcon(playButtonEnterImage3);
				playButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playButton3.setIcon(playButtonBasicImage3);
				playButton3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
				buttonClickedMusic.start();

				Thread blink = new Thread(new Runnable() {
					public void run() {
						IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
						try {
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png"))
									.getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png"))
									.getImage();
							Thread.sleep(500);
							playgamestart(e);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				});
				blink.start();
			}
		});
		add(playButton3);

		playButton4.addMouseListener(new MouseAdapter()// 열어라 자물쇠
		{
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton4.setIcon(playButtonEnterImage4);
				playButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playButton4.setIcon(playButtonBasicImage4);
				playButton4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
				buttonClickedMusic.start();

				Thread blink = new Thread(new Runnable() {
					public void run() {
						IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
						try {
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png"))
									.getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png"))
									.getImage();
							Thread.sleep(500);
							playgamestart(e);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				});
				blink.start();
			}
		});
		add(playButton4);
		playButton5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton5.setIcon(new5Icon);
				playButton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playButton5.setIcon(new5Icon);
				playButton5.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {

				Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
				buttonClickedMusic.start();

				Thread blink = new Thread(new Runnable() {
					public void run() {
						IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
						try {
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png"))
									.getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png"))
									.getImage();
							Thread.sleep(500);
							playgamestart(e);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				});

				blink.start();
			}
		});
		add(playButton5);

		rankButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rankButton.setIcon(rankEnterImage);
				rankButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rankButton.setIcon(rankBasicImage);
				rankButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
				buttonClickedMusic.start();
				IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.png")).getImage();
				dispose();
				new Rank(id);
			}
		});
		add(rankButton);

		TitleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				TitleButton.setIcon(TitleButtonEnterImage);
				TitleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				TitleButton.setIcon(TitleButtonBasicImage);
				TitleButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonClickedMusic = new Music("Title.mp3", false);
				buttonClickedMusic.start();
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				IntroBackground = new ImageIcon(Main.class.getResource("../images/IntroBackground.png")).getImage();
				playButton1.setVisible(true);
				rankButton.setVisible(false);
				playButton3.setVisible(false);
				playButton4.setVisible(false);
				playButton5.setVisible(false);
				playButton2.setVisible(false);

			}
		});
		add(TitleButton);
	}

	public void playgamestart(MouseEvent e) {

		playButton2.setVisible(false);
		playButton3.setVisible(false);
		playButton4.setVisible(false);
		playButton5.setVisible(false);
		rankButton.setVisible(false);

		Thread play = new Thread(new Runnable() {
			public void run() {
				ready3s(e);
				ready2s(e);
				ready1s(e);
			}
		});
		play.start();

	}

	public void ready3s(MouseEvent e2) {
		Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
		buttonClickedMusic.start();
		if (e2.getSource() == playButton3) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/3s.PNG")).getImage();
		}
		else if (e2.getSource() == playButton2) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/3s.PNG")).getImage();
		}
		else if (e2.getSource() == playButton4) {
			Image start_3 = new ImageIcon(Main.class.getResource("../images/horse_START_3.jpg")).getImage();
			IntroBackground = start_3.getScaledInstance(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
		}
		else if(e2.getSource() == playButton5)
		{
			IntroBackground = new ImageIcon(Main.class.getResource("../images/청기백기.PNG")).getImage();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void ready2s(MouseEvent e2) {
		Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
		buttonClickedMusic.start();
		if (e2.getSource() == playButton3) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/2s.PNG")).getImage();
		}
		else if (e2.getSource() == playButton2) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/2s.PNG")).getImage();
		}
		else if (e2.getSource() == playButton4) {
			Image start_3 = new ImageIcon(Main.class.getResource("../images/horse_START_2.jpg")).getImage();
			IntroBackground = start_3.getScaledInstance(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
		}
		else if(e2.getSource() == playButton5)
		{
			IntroBackground = new ImageIcon(Main.class.getResource("../images/청기백기.PNG")).getImage();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void ready1s(MouseEvent e2) {
		Music buttonClickedMusic = new Music("buttonClickedMusic.mp3", false);
		buttonClickedMusic.start();
		if (e2.getSource() == playButton3) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/1s.PNG")).getImage();
			try {
				Thread.sleep(1000);
				new game1(this.id);
				dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		else if (e2.getSource() == playButton2) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/1s.PNG")).getImage();
			try {
				Thread.sleep(1000);
				new game2(this.id);
				dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		

		else if (e2.getSource() == playButton4) {
			Image start_3 = new ImageIcon(Main.class.getResource("../images/horse_START_1.jpg")).getImage();
			IntroBackground = start_3.getScaledInstance(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
			try {
				Thread.sleep(1000);
				new game3(this.id);
				dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (e2.getSource() == playButton5) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/청기백기.PNG")).getImage();
			try {
				Thread.sleep(1000);
				new game4(this.id);
				dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setToCenter() {
		Dimension frameSize = getSize();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

	}
}
