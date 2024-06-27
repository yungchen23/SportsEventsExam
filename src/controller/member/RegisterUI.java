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
import javax.swing.border.LineBorder;

import controller.LoginUI;
import model.Member;
import service.Impl.MemberServiceImpl;
import util.Common;

public class RegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JPasswordField password;
	private JPasswordField password2;
	private JTextField name;

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
	public RegisterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 視窗設定
		Common.setWindows(this);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 5, 228, 628);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(RegisterUI.class.getResource("/controller/img/cover001.jpg")));
		lblNewLabel_4.setBounds(0, -16, 228, 644);
		panel.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(226, 0, 640, 633);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2.setBounds(151, 150, 375, 415);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel.setBounds(29, 46, 46, 15);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(27, 173, 46, 15);
		panel_2.add(lblNewLabel_1);

		account = new JTextField();
		account.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		account.setBounds(145, 35, 191, 42);
		panel_2.add(account);
		account.setColumns(10);

		password = new JPasswordField();
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		password.setBounds(143, 164, 191, 42);
		panel_2.add(password);

		password2 = new JPasswordField();
		password2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		password2.setBounds(143, 221, 191, 42);
		panel_2.add(password2);

		JLabel lblNewLabel_1_1 = new JLabel("再次確認密碼");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(27, 230, 106, 33);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("稱呼(姓名)");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(29, 108, 85, 15);
		panel_2.add(lblNewLabel_2);

		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		name.setColumns(10);
		name.setBounds(143, 97, 191, 42);
		panel_2.add(name);

		// 註冊

		JButton login = new JButton("送出註冊");
		login.setBackground(new Color(0, 255, 255));
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String Username = account.getText();
				String Name = name.getText();
				String Password = password.getText();
				String Password2 = password2.getText();

				// 1.先判斷帳號有無重複
				Member member = new MemberServiceImpl().getMemberByUser(Username);

				if (member != null) { // 有重複
					JOptionPane.showMessageDialog(null, "此組帳號已存在，請重新輸入", "提示", JOptionPane.WARNING_MESSAGE);
				} else {

					if (!(Password.equals(Password2))) {
						JOptionPane.showMessageDialog(null, "兩次密碼輸入不同，請重新輸入", "提示", JOptionPane.WARNING_MESSAGE);
					} else {

						if (Username.isEmpty() || Name.isEmpty() || Password.isEmpty() || Password2.isEmpty()) {

							JOptionPane.showMessageDialog(null, "欄位不能留空白", "提示", JOptionPane.WARNING_MESSAGE);
						} else {

							Member member2 = new Member(null, Name, Username, Password, true, null);
							new MemberServiceImpl().addMember(member2);

							JOptionPane.showMessageDialog(null, "註冊成功，請登入帳號", "提示", JOptionPane.WARNING_MESSAGE);

							LoginUI ui = new LoginUI();
							ui.setVisible(true);
							dispose();

						}
					}
				}
			}
		});
		login.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		login.setBounds(62, 295, 247, 42);
		panel_2.add(login);

		// 返回上一頁
		JButton register = new JButton("返回登入");
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

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 128));
		panel_3.setBounds(151, 81, 379, 48);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("註冊新帳號");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(142, 4, 110, 42);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_4_1 = new JLabel("New label");
		lblNewLabel_4_1.setIcon(new ImageIcon(RegisterUI.class.getResource("/controller/img/cover001.jpg")));
		lblNewLabel_4_1.setBounds(858, -11, 228, 644);
		contentPane.add(lblNewLabel_4_1);

	}
}
