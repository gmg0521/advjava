package Mini_Game_Heaven;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Mini_Game_Heaven.MemberDAO;
import Mini_Game_Heaven.Menu;

public class Rank extends JFrame implements ActionListener, WindowSetting{
	
	String id;
	
	Vector v, cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane scPane;
	
	int curGame = 1;

	private JPanel contentPane;
	private JLabel game;
	private JButton leftGameBtn;
	private JButton rightGameBtn;
	private JButton backBtn;
	
	private JLabel grandTier = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Rank("unknown");
	}

	/**
	 * Create the frame.
	 */
	public Rank(String id) {
		super("랭크");
		this.id = id;
		MemberDAO dao = new MemberDAO();
		v = dao.getMemberList("game1");
		
		System.out.println("v = " + v );
		cols = getColumn();
		model = new DefaultTableModel(v, cols);
		
		jTable = new JTable(model);
		jTable.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		scPane = new JScrollPane(jTable);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);
		contentPane.add(scPane);
		
		game = new JLabel("\uC5F4\uB824\uB77C! \uC790\uBB3C\uC1E0!");
		game.setFont(new Font("나눔고딕", Font.BOLD, 20));
		game.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(game, BorderLayout.NORTH);
		
		leftGameBtn = new JButton("\uCCAD\uAE30\uBC31\uAE30!");
		leftGameBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		leftGameBtn.setToolTipText("\uC774\uC804 \uAC8C\uC784\uC758 \uC21C\uC704\uB97C \uD655\uC778\uD569\uB2C8\uB2E4.");
		contentPane.add(leftGameBtn, BorderLayout.WEST);
		
		rightGameBtn = new JButton("\uCC28\uCC28\uCC28!");
		rightGameBtn.setToolTipText("\uB2E4\uC74C \uAC8C\uC784\uC758 \uC21C\uC704\uB97C \uD655\uC778\uD569\uB2C8\uB2E4.");
		rightGameBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		contentPane.add(rightGameBtn, BorderLayout.EAST);
		
		backBtn = new JButton("Back");
		backBtn.setToolTipText("\uB4A4\uB85C\uAC00\uAE30");
		backBtn.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		contentPane.add(backBtn, BorderLayout.SOUTH);
				
		leftGameBtn.addActionListener(this);
		rightGameBtn.addActionListener(this);
		backBtn.addActionListener(this);
		jTableRefresh("game1");
		setToCenter();
		setVisible(true);
	}

	public Vector getColumn() {
		Vector col = new Vector();
		col.add("Rank");
		col.add("Name");
		col.add("Score");
		col.add("Tier");
		
		return col;
	}
	
	public void jTableRefresh(String game) {
		MemberDAO dao = new MemberDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getMemberList(game), getColumn());
		jTable.setModel(model);
		for(int index = 0; index < v.size(); index++) {
			jTable.setValueAt("#"+(index+1), index, 0);
			switch(curGame) {
			case 1:
				int score1 = (int) jTable.getValueAt(index, 2);
				if( score1 >= 0 && score1 <= 3)
					jTable.setValueAt("브론즈", index, 3);
				else if(score1 >= 4 && score1 <= 6)
					jTable.setValueAt("실버", index, 3);
				else if(score1 >= 7 && score1 <= 9)
					jTable.setValueAt("골드", index, 3);
				else if(score1 >= 10 && score1 <= 11)
					jTable.setValueAt("플레티넘", index, 3);
				else if(score1 > 11)
					jTable.setValueAt("다이아몬드", index, 3);
				break;
			case 2:
				int score2 = (int) jTable.getValueAt(index, 2);
				if( score2 >= 0 && score2 <= 3)
					jTable.setValueAt("브론즈", index, 3);
				else if(score2 >= 4 && score2 <= 6)
					jTable.setValueAt("실버", index, 3);
				else if(score2 >= 7 && score2 <= 9)
					jTable.setValueAt("골드", index, 3);
				else if(score2 >= 10 && score2 <= 11)
					jTable.setValueAt("플레티넘", index, 3);
				else if(score2 > 11)
					jTable.setValueAt("다이아몬드", index, 3);
				break;
			case 3:
				Double score3 = (double) jTable.getValueAt(index, 2);
				if( score3 <= 30.000 && score3 >= 25.000)
					jTable.setValueAt("브론즈", index, 3);
				else if( score3 <= 24.999 && score3 >= 20.000)
					jTable.setValueAt("실버", index, 3);
				else if( score3 <= 19.999 && score3 >= 15.000)
					jTable.setValueAt("골드", index, 3);
				else if( score3 <= 14.999 && score3 >= 10.000)
					jTable.setValueAt("플레티넘", index, 3);
				else if(score3 <= 9.999)
					jTable.setValueAt("다이아몬드", index, 3);
				break;
			case 4:
				int score4 = (int) jTable.getValueAt(index, 2);
				if( score4 >= 0 && score4 <= 9)
					jTable.setValueAt("브론즈", index, 3);
				else if(score4 >= 10 && score4 <= 14)
					jTable.setValueAt("실버", index, 3);
				else if(score4 >= 15 && score4 <= 19)
					jTable.setValueAt("골드", index, 3);
				else if(score4 >= 20 && score4 <= 24)
					jTable.setValueAt("플레티넘", index, 3);
				else if(score4 > 24)
					jTable.setValueAt("다이아몬드", index, 3);
				break; 	
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == rightGameBtn) {
			curGame++;
			if(curGame >= 5)
				curGame = 1;
			jTableRefresh("game"+curGame);
			switch(curGame) {
			case 1:
				game.setText("열려라! 자물쇠!");
				leftGameBtn.setText("청기백기!");
				rightGameBtn.setText("다함께! 차차차!");
				break;
			case 2:
				game.setText("다함께! 차차차!");
				leftGameBtn.setText("열려라! 자물쇠!");
				rightGameBtn.setText("달려라! 경주마!");
				break;
			case 3:
				game.setText("달려라! 경주마!");
				leftGameBtn.setText("다함깨! 차차차!");
				rightGameBtn.setText("청기백기!");
				break;
			case 4:
				game.setText("청기백기!");
				leftGameBtn.setText("달려라! 경주마!");
				rightGameBtn.setText("열려라! 자물쇠!");
				break;
			}
		}
		if(e.getSource() == leftGameBtn) {
			curGame--;
			if(curGame <= 0)
				curGame = 4;
			jTableRefresh("game"+curGame);
			switch(curGame) {
			case 1:
				game.setText("열려라! 자물쇠!");
				leftGameBtn.setText("청기백기!");
				rightGameBtn.setText("다함께! 차차차!");
				break;
			case 2:
				game.setText("다함께! 차차차!");
				leftGameBtn.setText("열려라! 자물쇠!");
				rightGameBtn.setText("달려라! 경주마!");
				break;
			case 3:
				game.setText("달려라! 경주마!");
				leftGameBtn.setText("다함깨! 차차차!");
				rightGameBtn.setText("청기백기!");
				break;
			case 4:
				game.setText("청기백기!");
				leftGameBtn.setText("달려라! 경주마!");
				rightGameBtn.setText("열려라! 자물쇠!");
				break;
			}
		}
		if(e.getSource() == backBtn) {
			dispose();
			new Menu(id,"IntroBackground");
		}
	}

	@Override
	public void setToCenter() {
		Dimension frameSize = getSize();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
	}

}
