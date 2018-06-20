package Mini_Game_Heaven;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Mini_Game_Heaven.MemberDAO;

public class game4 extends GameInterface implements KeyListener {

	MemberDAO dao = new MemberDAO();

	String id;

	boolean is = false;

	private JPanel contentPane;

	private JLabel flagMan;
	private JLabel command;
	private JLabel scoreLabel;

	Thread chkTime = new Thread();

	private Random rand = new Random();

	int score = 0;

	String postState = "";

	String[] commandList = { "청기 올려!", "백기 올려!", "청기 내려!", "백기 내려!", "청기 내리고 백기 올려!", "백기 내리고 청기 올려!", "청기 올리고 백기 올려!",
			"백기 내리고 청기 내려!" };

	ImageIcon defaultFlag = new ImageIcon(game4.class.getResource("/images/defaultFlag.png"));
	ImageIcon blueFlagUp = new ImageIcon(game4.class.getResource("/images/blueFlagUp.png"));
	ImageIcon whiteFlagUp = new ImageIcon(game4.class.getResource("/images/whiteFlagUp.png"));
	ImageIcon allFlagUp = new ImageIcon(game4.class.getResource("/images/allFlagUp.png"));

	public static void main(String[] args) {
		new game4("unknown");
	}

	public game4(String id) {
		super("청기백기", "Game4background");
		this.id = id;
		setContentPane(getContentPane());
		setVisible(true);

		flagMan = new JLabel();
		flagMan.setBounds(381, 250, 240, 169);
		getContentPane().add(flagMan);

		postState = "defaultFlag";
		flagMan.setIcon(defaultFlag);
		flagMan.setName("defaultFlag");

		command = new JLabel("청기백기");
		command.setHorizontalAlignment(SwingConstants.CENTER);
		command.setBounds(355, 200, 300, 50);
		command.setFont(new Font("굵은안상수체", Font.PLAIN, 30));
		command.setForeground(Color.WHITE);
		command.setText(commandList[rand.nextInt(8)]);

		getContentPane().add(command);
		getContentPane().add(flagMan);

		scoreLabel = new JLabel("0");
		scoreLabel.setBounds(495, 100, 50, 50);
		scoreLabel.setFont(new Font("굵은안상수체", Font.PLAIN, 40));
		scoreLabel.setForeground(Color.WHITE);
		getContentPane().add(scoreLabel);

		timeLabel.setBounds(460, 100, 100, 150);
		timeLabel.setFont(new Font("굵은안상수체", Font.PLAIN, 40));
		timeLabel.setForeground(Color.WHITE);
		getContentPane().add(timeLabel);

		this.addKeyListener(this);

		requestFocus();
		tictic();
		chkTime = new Thread(() -> {
			while (is == false) {
				try {
					if (Double.parseDouble(timeLabel.getText()) < 0) {
						gameOver();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		chkTime.start();
	}

	private boolean gameOver() {
		chkTime.interrupt();
		is = true;
		JOptionPane.showMessageDialog(null, "게임 종료", "GAME OVER!", EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(null, "Score \n\n"+ scoreLabel.getText()+ "!!!", "점수", EXIT_ON_CLOSE);
		if(dao.setScore(this.id, "game4", Integer.parseInt(scoreLabel.getText()))) {
			dispose();
			new Menu(id,"IntroBackground");
		}
		else
			JOptionPane.showMessageDialog(this, "점수 저장 실패");
		return is;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (is == false) {
			switch (key) {
			case KeyEvent.VK_NUMPAD1:
				if (flagMan.getIcon() == whiteFlagUp) {
					flagMan.setIcon(defaultFlag);
					flagMan.setName("defaultFlag");
					break;
				} else if (flagMan.getIcon() == allFlagUp) {
					flagMan.setIcon(blueFlagUp);
					flagMan.setName("blueFlagUp");
					break;
				} else {
					if (flagMan.getName().equals("blueFlagUp"))
						flagMan.setName("blueFlagUp");
					else
						flagMan.setName("defaultFlag");
					break;
				}
			case KeyEvent.VK_NUMPAD7:
				if (flagMan.getIcon() == blueFlagUp) {
					flagMan.setIcon(allFlagUp);
					flagMan.setName("allFlagUp");
					break;
				} else if (flagMan.getIcon() == defaultFlag) {
					flagMan.setIcon(whiteFlagUp);
					flagMan.setName("whiteFlagUp");
					break;
				} else {
					if (flagMan.getName().equals("allFlagUp"))
						flagMan.setName("allFlagUp");
					else
						flagMan.setName("whiteFlagUp");
					break;
				}
			case KeyEvent.VK_NUMPAD3:
				if (flagMan.getIcon() == blueFlagUp) {
					flagMan.setIcon(defaultFlag);
					flagMan.setName("defaultFlag");
					break;
				} else if (flagMan.getIcon() == allFlagUp) {
					flagMan.setIcon(whiteFlagUp);
					flagMan.setName("whiteFlagUp");
					break;
				} else {
					if (flagMan.getName().equals("whiteFlagUp"))
						flagMan.setName("whiteFlagUp");
					else
						flagMan.setName("defaultFlag");
					break;
				}
			case KeyEvent.VK_NUMPAD9:
				if (flagMan.getIcon() == defaultFlag) {
					flagMan.setIcon(blueFlagUp);
					flagMan.setName("blueFlagUp");
					break;
				} else if (flagMan.getIcon() == whiteFlagUp) {
					flagMan.setIcon(allFlagUp);
					flagMan.setName("allFlagUp");
					break;
				} else {
					if (flagMan.getName().equals("blueFlagUp"))
						flagMan.setName("blueFlagUp");
					else
						flagMan.setName("allFlagUp");
					break;
				}
			case KeyEvent.VK_SPACE:
				if (isRight()) {
					rand.setSeed(System.currentTimeMillis());
					postState = flagMan.getName();
					command.setText(commandList[rand.nextInt(8)]);
					break;
				} else
					break;
			}
		}
	}

	private boolean isRight() {

		boolean correct = false;

		/*
		 * 명령에 잘했는지 체크
		 */
		/*
		 * 0 = "청기 올려!" 1 = "백기 올려!" 2 = "청기 내려!" 3 = "백기 내려!" 4 = "청기 내리고 백기 올려!" 5 =
		 * "백기 내리고 청기 올려!" 6 = "청기 올리고 백기 올려!" 7 = "백기 내리고 청기 내려!"
		 */
		if (flagMan.getIcon() == defaultFlag && flagMan.getName().equals("defaultFlag")) {
			if (postState.equals("blueFlagUp")
					&& ((command.getText().equals(commandList[2])) || (command.getText().equals(commandList[7])))) {
				correct = true;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				score++;
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("whiteFlagUp") && (command.getText().equals(commandList[3]))
					|| command.getText().equals(commandList[7])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("allFlagUp") && command.getText().equals(commandList[7])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("defaultFlag") && command.getText().equals(commandList[2])
					|| command.getText().equals(commandList[3]) || command.getText().equals(commandList[7])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			}
		} else if (flagMan.getIcon() == whiteFlagUp && flagMan.getName().equals("whiteFlagUp")) {
			if (postState.equals("blueFlagUp") && command.getText().equals(commandList[4])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("whiteFlagUp") && command.getText().equals(commandList[1])
					|| command.getText().equals(commandList[2]) || command.getText().equals(commandList[4])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("allFlagUp") && command.getText().equals(commandList[2])
					|| command.getText().equals(commandList[4])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("defaultFlag") && command.getText().equals(commandList[1])
					|| command.getText().equals(commandList[4])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			}
		} else if (flagMan.getIcon() == blueFlagUp && flagMan.getName().equals("blueFlagUp")) {
			if (postState.equals("whiteFlagUp") && command.getText().equals(commandList[5])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("blueFlagUp") && command.getText().equals(commandList[0])
					|| command.getText().equals(commandList[3]) || command.getText().equals(commandList[5])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("allFlagUp") && command.getText().equals(commandList[3])
					|| command.getText().equals(commandList[5])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("defaultFlag") && command.getText().equals(commandList[0])
					|| command.getText().equals(commandList[5])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			}
		} else if (flagMan.getIcon() == allFlagUp && flagMan.getName().equals("allFlagUp")) {
			if (postState.equals("blueFlagUp")
					&& ((command.getText().equals(commandList[1])) || (command.getText().equals(commandList[6])))) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("whiteFlagUp") && (command.getText().equals(commandList[0]))
					|| command.getText().equals(commandList[6])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("defaultFlag") && command.getText().equals(commandList[6])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			} else if (postState.equals("allFlagUp") && command.getText().equals(commandList[0])
					|| command.getText().equals(commandList[1]) || command.getText().equals(commandList[6])) {
				correct = true;
				score++;
				Music c = new Music("청기백기정답.mp3", false);
				c.start();
				scoreLabel.setText(String.valueOf(score));
			}
		}
		return correct;

	}
}
