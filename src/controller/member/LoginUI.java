package controller.member;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CommonUI;
import controller.events.EventListUI;
import controller.events.EventUI;
import model.Member;
import service.Impl.MemberServiceImpl;
import util.Common;
import util.Temp;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JPasswordField password;
//	private String sqlPath = "dbInfo.txt";
	private String filePath = "member.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 552, 633);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(534, 0, 552, 633);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(120, 217, 312, 237);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 26, 46, 15);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(29, 81, 46, 15);
		panel_2.add(lblNewLabel_1);

		account = new JTextField();
		account.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		account.setBounds(85, 15, 191, 42);
		panel_2.add(account);
		account.setColumns(10);

		password = new JPasswordField();
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		password.setBounds(85, 72, 191, 42);
		panel_2.add(password);

		// 視窗設定
		Common.setWindows(this);

		JLabel forgot = new JLabel(">忘記密碼");
		forgot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotUI ui = new ForgotUI();
				ui.setVisible(true);
				dispose();
			}
		});
		forgot.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		forgot.setBounds(212, 193, 95, 28);
		panel_2.add(forgot);

		JLabel forgot_1 = new JLabel(">我要註冊");
		forgot_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterUI ui = new RegisterUI();
				ui.setVisible(true);
				dispose();
			}
		});
		forgot_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		forgot_1.setBounds(29, 193, 95, 28);
		panel_2.add(forgot_1);

		// =====帳號登入======================

		JButton login = new JButton("登入");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String Username = account.getText();
				String Password = password.getText();

				if (Username.isEmpty() || Password.isEmpty()) {

					JOptionPane.showMessageDialog(null, "要填寫帳號跟密碼才能登入唷!!", "登入提示", JOptionPane.WARNING_MESSAGE);

				} else {

					// 載入會員帳號密碼
					Member member = new MemberServiceImpl().getMemberByUser(Username, Password);

					// 判斷帳號是否存在
					if (member != null) {

						Temp.saveFile(filePath, member); // 寫入暫存檔
						JOptionPane.showMessageDialog(null, "登入成功", "登入提示", JOptionPane.WARNING_MESSAGE);

						EventUI ui = new EventUI();
						ui.setVisible(true);
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "帳號密碼輸入錯誤，請重新輸入", "登入提示", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		login.setBackground(new Color(0, 255, 255));
		login.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		login.setBounds(29, 141, 247, 42);
		panel_2.add(login);

		// ==離開============================

		JButton register = new JButton("離開程式");
		register.setForeground(new Color(255, 255, 255));
		register.setBackground(new Color(0, 0, 255));
		register.setBounds(429, 581, 113, 42);
		panel_1.add(register);
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String msg1 = "你是否要離開這個程式?";
				String msg2 = "離開程式";

				CommonUI.twoOption(msg1, msg2, () -> dispose());
			}
		});
		register.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

		// ===連線設定============================

//		JLabel lblNewLabel_4 = new JLabel("New label");
//		lblNewLabel_4.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				DbsettingUI ui = new DbsettingUI();
//				ui.setVisible(true);
//				dispose();
//
//			}
//		});
//		lblNewLabel_4.setIcon(new ImageIcon(LoginUI.class.getResource("/Controller/img/seeting.png")));
//		lblNewLabel_4.setBounds(502, 10, 40, 42);
//		panel_1.add(lblNewLabel_4);

		// =========假第三方登入=================================================

		JLabel lblNewLabel_4_1 = new JLabel("New label");
		lblNewLabel_4_1.setBounds(155, 453, 261, 62);
		panel_1.add(lblNewLabel_4_1);
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showMessageDialog(null, "當然還沒串啊，這是越級打怪嗎!?", "別鬧了，第三方串接!!", JOptionPane.WARNING_MESSAGE);

			}
		});
		lblNewLabel_4_1.setIcon(new ImageIcon(LoginUI.class.getResource("/Controller/img/login2.png")));

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(LoginUI.class.getResource("/controller/img/blueshoes-logo3.png")));
		lblNewLabel_3.setBounds(10, 113, 520, 79);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("background");
		lblNewLabel_2.setIcon(new ImageIcon(LoginUI.class.getResource("/controller/img/cover003.png")));
		lblNewLabel_2.setBounds(0, 0, 547, 633);
		panel.add(lblNewLabel_2);

	}
}
