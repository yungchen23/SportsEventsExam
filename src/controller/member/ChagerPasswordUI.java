package controller.member;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CommonUI;
import model.Member;
import service.Impl.MemberServiceImpl;
import util.Common;
import util.Temp;

public class ChagerPasswordUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JPasswordField newPassword;
	private JPasswordField rePassword;
	private Member member; // 儲存個人狀態用
	private String filePath = "member.txt";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChagerPasswordUI frame = new ChagerPasswordUI();
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
	public ChagerPasswordUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 1086, 633);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// -----登入資訊----------------------------------------------------------

		Object obj = Temp.readFile(filePath);
		member = (Member) obj;
		System.out.println("1="+member.getMemberAge());
		

		// -----上方選單----------------------------------------------------------

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 1086, 68);
		panel.add(panel_3);

		CommonUI.TopMenu(panel_3, this);

		// -----側邊選單(Member)----------------------------------------------------

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 69, 139, 554);
		panel.add(panel_1);
	
		JPanel side_panel_1 = new JPanel();
		side_panel_1.setLayout(null);
		side_panel_1.setBounds(0, 0, 139, 554);
		panel_1.add(side_panel_1);
		
		CommonUI.SideMenuMember(side_panel_1, this);
						
		//--登出離開------------------------
		
		CommonUI.exitMenu(side_panel_1, this);
		
		//--登入資訊--------------
		
		CommonUI.userInfo(side_panel_1,member); 

		

		JLabel memberName = new JLabel((String) null);
		memberName.setBounds(10, 10, 121, 30);
		panel_1.add(memberName);
		memberName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

		JLabel memberId = new JLabel((String) null);
		memberId.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		memberId.setBounds(10, 39, 121, 30);
		panel_1.add(memberId);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(159, 69, 927, 554);
		panel.add(panel_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(9, 7, 908, 65);
		panel_1_1.add(panel_3_1);

		JLabel title = new JLabel("修改密碼");
		title.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		title.setBounds(10, 10, 132, 42);
		panel_3_1.add(title);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1.setBounds(10, 84, 907, 460);
		panel_1_1.add(panel_2_1);

		JLabel lblNewLabel_1 = new JLabel("輸入新密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(21, 30, 106, 15);
		panel_2_1.add(lblNewLabel_1);

		newPassword = new JPasswordField();
		newPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		newPassword.setBounds(137, 21, 191, 42);
		panel_2_1.add(newPassword);

		JLabel lblNewLabel_1_1 = new JLabel("再次確認密碼");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(21, 87, 106, 33);
		panel_2_1.add(lblNewLabel_1_1);

		rePassword = new JPasswordField();
		rePassword.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		rePassword.setBounds(137, 78, 191, 42);
		panel_2_1.add(rePassword);

		JButton saveNewPassword = new JButton("儲存");
		saveNewPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Password = newPassword.getText();
				String Password2 = rePassword.getText();

				if (Password.isEmpty() || Password2.isEmpty()) {

					JOptionPane.showMessageDialog(null, "總是要寫點東西，才能變更你的密碼喔", "修改密碼", JOptionPane.WARNING_MESSAGE);

				} else {

					if (!(Password.equals(Password2))) {
						JOptionPane.showMessageDialog(null, "兩次密碼輸入不同，請重新輸入", "修改密碼", JOptionPane.WARNING_MESSAGE);
					} else {
						
						member.setMemberPassword(Password);
						new MemberServiceImpl().updateMember(member.getId(), member.getMemberPassword());

						System.out.println(member.getMemberId() + "-" + member.getMemberPassword());

						JOptionPane.showMessageDialog(null, "密碼修改成功", "修改密碼", JOptionPane.WARNING_MESSAGE);
						newPassword.setText("");
						rePassword.setText("");

					}
				}
			}
		});
		saveNewPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		saveNewPassword.setBackground(Color.GREEN);
		saveNewPassword.setBounds(704, 417, 193, 33);
		panel_2_1.add(saveNewPassword);

		// 視窗設定
		Common.setWindows(this);
	}

}
