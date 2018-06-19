package game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
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

public class Menu extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphics;

	private Image blink = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();

	private ImageIcon TitleButtonEnterImage = new ImageIcon(Main.class.getResource("../images/TitleButtonEnter.png"));
	private ImageIcon TitleButtonBasicImage = new ImageIcon(Main.class.getResource("../images/TitleButtonBasic.png"));
	private JButton TitleButton = new JButton(TitleButtonBasicImage);

	private ImageIcon exitButtonEnterImage = new ImageIcon(Main.class.getResource("../images/exit_red.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exit_black.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);

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

	private Image IntroBackground = new ImageIcon(Main.class.getResource("/images/IntroBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private int mouseX, mouseY;

	public Menu() {
		setUndecorated(true);
		setTitle("GAME");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		TitleButton.setBounds(580, 566, 150, 150);
		TitleButton.setBorderPainted(false);
		TitleButton.setContentAreaFilled(false);
		TitleButton.setFocusPainted(false);

		exitButton.setBounds(690, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);

		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnterImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonClickedMusic = new Music("menuout.mp3", false);
				buttonClickedMusic.start();
				try {
					Thread.sleep(800);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);

		playButton1.setBounds(50, 300, 100, 100);
		playButton1.setBorderPainted(false);
		playButton1.setContentAreaFilled(false);
		playButton1.setFocusPainted(false);

		playButton2.setBounds(180, 300, 200, 200);
		playButton2.setBorderPainted(false);
		playButton2.setContentAreaFilled(false);
		playButton2.setFocusPainted(false);
		playButton2.setVisible(false);

		playButton3.setBounds(10, 300, 200, 200);
		playButton3.setBorderPainted(false);
		playButton3.setContentAreaFilled(false);
		playButton3.setFocusPainted(false);
		playButton3.setVisible(false);
		
		playButton4.setBounds(300, 300, 200, 200);
		playButton4.setBorderPainted(false);
		playButton4.setContentAreaFilled(false);
		playButton4.setFocusPainted(false);
		playButton4.setVisible(false);

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

				IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.jpg")).getImage();
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
				IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.jpg")).getImage();
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
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.jpg")).getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
							Thread.sleep(50);
							IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.jpg")).getImage();
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
									IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.jpg")).getImage();
									Thread.sleep(50);
									IntroBackground = new ImageIcon(Main.class.getResource("../images/blink.jpg")).getImage();
									Thread.sleep(50);
									IntroBackground = new ImageIcon(Main.class.getResource("../images/playBackground1.jpg")).getImage();
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
				IntroBackground = new ImageIcon(Main.class.getResource("../images/IntroBackground.jpg")).getImage();
				playButton1.setVisible(true);
				playButton2.setVisible(false);
				playButton3.setVisible(false);

			}
		});
		add(TitleButton);

		menuBar.setBounds(0, 0, 1200, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		Music introMusic = new Music("IntroMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		screenDraw(screenGraphics);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(IntroBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

	public void playgamestart(MouseEvent e) {

		playButton2.setVisible(false);
		playButton3.setVisible(false);
		playButton4.setVisible(false);

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
		if(e2.getSource() == playButton3) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/game1_3s.jpg")).getImage();
		} else if(e2.getSource() == playButton4) {
			Image start_2 = new ImageIcon(Main.class.getResource("../images/horse_START_3.jpg")).getImage();
			
			IntroBackground = start_2.getScaledInstance(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
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
		if(e2.getSource() == playButton3) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/game1_2s.jpg")).getImage();
		} else if(e2.getSource() == playButton4) {
			Image start_2 = new ImageIcon(Main.class.getResource("../images/horse_START_2.jpg")).getImage();
			
			IntroBackground = start_2.getScaledInstance(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
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
		if(e2.getSource() == playButton3) {
			IntroBackground = new ImageIcon(Main.class.getResource("../images/game1_1s.jpg")).getImage();
			try {
				Thread.sleep(1000);
				new game1();
				dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if(e2.getSource() == playButton4) {
			Image start_2 = new ImageIcon(Main.class.getResource("../images/horse_START_1.jpg")).getImage();
			IntroBackground = start_2.getScaledInstance(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, Image.SCALE_SMOOTH);
			try {
				Thread.sleep(1000);
				new game2();
				dispose();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
