package Mini_Game_Heaven;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Mini_Game_Heaven.Main;
import Mini_Game_Heaven.MemberDAO;
import Mini_Game_Heaven.game1;

public class Login extends JFrame implements ActionListener, WindowSetting, KeyListener{

	private JPanel contentPane;
	private JPasswordField pwTextField;
	private JTextField textField;
	private JButton loginBtn;

	/**
	 * Create the frame.
	 */
	public Login() { 
		
		setResizable(false);
		setTitle("\uB85C\uADF8\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setToCenter();
		setContentPane(contentPane);
		
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("a가시고기B", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setToolTipText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694.");
		textField.setFont(new Font("a가시고기B", Font.PLAIN, 20));
		textField.setColumns(10);
		
		JLabel lblPw = new JLabel("PW : ");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("a가시고기B", Font.BOLD, 20));
		
		pwTextField = new JPasswordField();
		pwTextField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
		pwTextField.setColumns(10);
		panel.setLayout(new GridLayout(2, 2, 0, 5));
		panel.add(lblId);
		panel.add(textField);
		panel.add(lblPw);
		panel.add(pwTextField);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton joinBtn = new JButton("Join");
		joinBtn.setToolTipText("\uD68C\uC6D0\uAC00\uC785 \uCC3D\uC744 \uB744\uC6C1\uB2C8\uB2E4");
		joinBtn.setFont(new Font("a가시고기B", Font.BOLD, 17));
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {;
				Join join;
				Join.main(null);
			}
		});
		panel_1.add(joinBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setToolTipText("\uB85C\uADF8\uC778\uC744 \uD569\uB2C8\uB2E4");
		loginBtn.setFont(new Font("a가시고기B", Font.BOLD, 17));
		loginBtn.addActionListener(this);
		panel_1.add(loginBtn);
		
		this.addKeyListener(this);
		textField.addKeyListener(this);
		pwTextField.addKeyListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			String id =	textField.getText();
			@SuppressWarnings("deprecation")
			String pw = pwTextField.getText();
			if(id.equals("") || pw.equals(""))
				JOptionPane.showMessageDialog(this, "아이디 혹은 비밀번호를 입력하세요!");
			else {
				MemberDAO dao = new MemberDAO();
				if(dao.chkIdPw(id, pw)) {
					JOptionPane.showMessageDialog(this, "환영합니다! " + id + "님!");
					new Main(id, "IntroBackground");
					dispose();
				}
				else
					JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다");
			}
		}
	}

	@Override
	public void setToCenter() {
		Dimension frameSize = getSize();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
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
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!(getFocusOwner() == this)) {
				String id =	textField.getText();
				@SuppressWarnings("deprecation")
				String pw = pwTextField.getText();
				if(id.equals("") || pw.equals("")) {
					JOptionPane.showMessageDialog(this, "아이디 혹은 비밀번호를 입력하세요!");
					loginBtn.requestFocus();
				} else {
					MemberDAO dao = new MemberDAO();
					if(dao.chkIdPw(id, pw)) {
						JOptionPane.showMessageDialog(this, "환영합니다! " + id + "님!");
						new Main(id,"IntroBackground");
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다");
						loginBtn.requestFocus();
					}
				}
			}
		}
	}

}
