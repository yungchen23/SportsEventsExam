package controller.member;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.LoginUI;
import model.Member;
import service.Impl.MemberServiceImpl;
import util.Common;
import javax.swing.ImageIcon;

public class ForgotUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginUI frame = new LoginUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ForgotUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(247, 0, 595, 633);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel_2.setBounds(86, 107, 405, 424);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("輸入你的帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel.setBounds(31, 79, 177, 31);
		panel_2.add(lblNewLabel);

		account = new JTextField();
		account.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		account.setBounds(41, 132, 293, 42);
		panel_2.add(account);
		account.setColumns(10);

		// 視窗設定
		Common.setWindows(this);

		// 註冊

		JButton login = new JButton("這裡註冊");
		login.setBackground(new Color(192, 192, 192));
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				RegisterUI ui = new RegisterUI();
				ui.setVisible(true);
				dispose();

			}
		});
		login.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		login.setBounds(62, 295, 247, 42);
		panel_2.add(login);

		// 返回上一頁
		JButton register = new JButton("返回上一頁");
		register.setBackground(new Color(192, 192, 192));
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				LoginUI ui = new LoginUI();
				ui.setVisible(true);
				dispose();

			}
		});
		register.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		register.setBounds(62, 356, 247, 42);
		panel_2.add(register);

		
		
		JButton login_1 = new JButton("送出");
		login_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String Username = account.getText();
				String rePassword;
				Member member = null;
				
				// 載入會員帳號密碼
				member = new MemberServiceImpl().getMemberByUser(Username);
				if(Username.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "你不寫帳號，我怎麼告訴你密碼呢!!", "查詢密碼", JOptionPane.WARNING_MESSAGE);
					
				}else {
					
					if (member != null) {
						rePassword = member.getMemberPassword();
						account.setText("");
						JOptionPane.showMessageDialog(null, "你的密碼是\n【"+rePassword+"】", "查詢密碼", JOptionPane.WARNING_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "查無此帳號!!", "查詢密碼", JOptionPane.WARNING_MESSAGE);
						account.setText("");
					}
				}
			}
		});
		login_1.setBackground(new Color(0, 255, 255));
		login_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		login_1.setBounds(41, 196, 293, 42);
		panel_2.add(login_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 255, 128));
		panel_3.setBounds(14, 21, 379, 48);
		panel_2.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("查詢密碼");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(142, 4, 110, 42);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ForgotUI.class.getResource("/controller/img/2023-03-27-1.jpg")));
		lblNewLabel_1.setBounds(0, 0, 248, 633);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(ForgotUI.class.getResource("/controller/img/2023-03-27-1.jpg")));
		lblNewLabel_1_1.setBounds(838, 0, 248, 633);
		contentPane.add(lblNewLabel_1_1);

	}
}
