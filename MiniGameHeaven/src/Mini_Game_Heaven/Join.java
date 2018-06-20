package Mini_Game_Heaven;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Mini_Game_Heaven.MemberDAO;
import Mini_Game_Heaven.MemberDTO;

public class Join extends JFrame implements WindowSetting{

	private JPanel contentPane;
	private JTextField idTextField;
	private JPasswordField pwTextField;
	private JPasswordField pwConfirmTextField;
	private String id, pw;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Join() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setToCenter();
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 2, 0, 5));
		
		JLabel idJLabel = new JLabel("ID : ");
		idJLabel.setFont(new Font("a가시고기B", Font.BOLD, 20));
		idJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(idJLabel);
		
		idTextField = new JTextField();
		idTextField.setFont(new Font("a가시고기B", Font.PLAIN, 12));
		panel_1.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel pwJLabel = new JLabel("PW : ");
		pwJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwJLabel.setFont(new Font("a가시고기B", Font.BOLD, 20));
		panel_1.add(pwJLabel);
		
		pwTextField = new JPasswordField();
		pwTextField.setFont(new Font("a가시고기B", Font.PLAIN, 12));
		pwTextField.setColumns(10);
		panel_1.add(pwTextField);
		
		JLabel pwConfirmJLabel = new JLabel("PW Confirm : ");
		pwConfirmJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwConfirmJLabel.setFont(new Font("a가시고기B", Font.BOLD, 20));
		panel_1.add(pwConfirmJLabel);
		
		pwConfirmTextField = new JPasswordField();
		pwConfirmTextField.setFont(new Font("a가시고기B", Font.PLAIN, 12));
		pwConfirmTextField.setColumns(10);
		panel_1.add(pwConfirmTextField);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idTextField.getText();
				String pw = pwTextField.getText();
				String pwc = pwConfirmTextField.getText();
				
				if (pw.equals(pwc)) {
					
				}
			}
		});
		panel.add(btnJoin);
		btnJoin.setFont(new Font("a가시고기B", Font.BOLD, 17));
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					insertMember();
			}

		});
		
		JButton btnBack = new JButton("Back");
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setFont(new Font("a가시고기B", Font.BOLD, 17));
	}
	
	private void insertMember() {
		
		String id = idTextField.getText();
		String pw = pwTextField.getText();
		String pwc = pwConfirmTextField.getText();
		
		
		if(pw.equals("") || id.equals("")) {
			JOptionPane.showMessageDialog(this, "공백 입력은 불가능 합니다.");
		} else if(!pw.equals(pwc)) {
			JOptionPane.showMessageDialog(this, "패스워드와 패스워드 확인 값이 맞지 않습니다.");
		} else if(pw.equals(pwc)) {
			MemberDTO dto = getViewData();
			MemberDAO dao = new MemberDAO();
			
			boolean isJoin = dao.insertMember(dto);
			
			if(isJoin) {
				JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
				dispose();
			} else
				JOptionPane.showMessageDialog(this, "가입을 실패했습니다.");		
		}
	}

	private MemberDTO getViewData() {	// 화면에 입력한 내용 가져옴
		
		MemberDTO dto = new MemberDTO();
		
		String id = idTextField.getText();
		String pw = pwTextField.getText();
		
		dto.setId(id);
		dto.setPw(pw);
		dto.setScore1(0);
		dto.setScore2(0);
		dto.setScore3(30.000);
		dto.setScore4(0);
		
		return dto;
	}

	@Override
	public void setToCenter() {
		Dimension frameSize = getSize();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
		
	}

}
