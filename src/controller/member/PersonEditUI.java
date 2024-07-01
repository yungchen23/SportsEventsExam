package controller.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import controller.CommonUI;
import model.Clubs;
import model.Member;
import model.MemberState;
import service.Impl.ClubsServiceImpl;
import service.Impl.MemberServiceImpl;
import service.Impl.MemberStateServiceImpl;
import util.Common;
import util.Temp;

public class PersonEditUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField membername;
	private JTextField phone;
	private JTextField memberemail;
	private String SexOpt; // 性別combobox用
	private Member member; // 儲存個人狀態用
	private String filePath = "member.txt";
	private JTextField location;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonEditUI frame = new PersonEditUI();
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
	public PersonEditUI() {
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

		CommonUI.CookieData2();
		member = CommonUI.member;

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

		// --登出離開------------------------

		CommonUI.exitMenu(side_panel_1, this);

		// --登入資訊--------------

		CommonUI.userInfo(side_panel_1, member);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(159, 69, 927, 554);
		panel.add(panel_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(9, 7, 908, 65);
		panel_1_1.add(panel_3_1);

		JLabel title = new JLabel("個人資訊");
		title.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		title.setBounds(10, 10, 132, 42);
		panel_3_1.add(title);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1_1.setBounds(9, 82, 908, 462);
		panel_1_1.add(panel_2_1_1);

		JLabel lblNewLabel_4 = new JLabel("帳號");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(24, 10, 85, 40);
		panel_2_1_1.add(lblNewLabel_4);

		JLabel lblNewLabel_1_2 = new JLabel("生日");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(23, 255, 85, 40);
		panel_2_1_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("性別");
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(23, 305, 85, 40);
		panel_2_1_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("稱呼(姓名)");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(23, 101, 85, 40);
		panel_2_1_1.add(lblNewLabel_2_2);

		membername = new JTextField();
		membername.setText((String) null);
		membername.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		membername.setColumns(10);
		membername.setBounds(110, 101, 217, 40);
		panel_2_1_1.add(membername);

		phone = new JTextField();
		phone.setText((String) null);
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		phone.setColumns(10);
		phone.setBounds(110, 205, 217, 40);
		panel_2_1_1.add(phone);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("連絡電話");
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(23, 204, 85, 40);
		panel_2_1_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("個人介紹");
		lblNewLabel_3_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(412, 101, 85, 40);
		panel_2_1_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("隸屬社團");
		lblNewLabel_2_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(412, 51, 85, 40);
		panel_2_1_1.add(lblNewLabel_2_1_1);

		JLabel account = new JLabel((String) null);
		account.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		account.setBounds(108, 10, 300, 40);
		panel_2_1_1.add(account);

		JLabel userclub = new JLabel("未登入");
		userclub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		userclub.setBounds(497, 51, 217, 40);
		panel_2_1_1.add(userclub);

		// ==============性別選單================================

		JComboBox sexOpt = new JComboBox();
		sexOpt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object opt = sexOpt.getSelectedItem();
				SexOpt = (String) opt;
			}
		});
		sexOpt.setModel(new DefaultComboBoxModel(new String[] { "男性", "女性", "不願透露" }));
		sexOpt.setSelectedIndex(0);
		sexOpt.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		sexOpt.setBounds(110, 305, 217, 40);
		panel_2_1_1.add(sexOpt);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("年齡");
		lblNewLabel_1_1_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(24, 347, 85, 40);
		panel_2_1_1.add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("電子信箱");
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(23, 151, 85, 40);
		panel_2_1_1.add(lblNewLabel_1_1_1_1_1);

		JLabel ffff = new JLabel("地區");
		ffff.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		ffff.setBounds(24, 390, 85, 40);
		panel_2_1_1.add(ffff);

		location = new JTextField();
		location.setText((String) null);
		location.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		location.setColumns(10);
		location.setBounds(108, 390, 217, 40);
		panel_2_1_1.add(location);

		memberemail = new JTextField();
		memberemail.setText((String) null);
		memberemail.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		memberemail.setColumns(10);
		memberemail.setBounds(110, 152, 217, 40);
		panel_2_1_1.add(memberemail);

		JLabel lblNewLabel_4_1 = new JLabel("ID");
		lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(23, 51, 85, 40);
		panel_2_1_1.add(lblNewLabel_4_1);

		JLabel memberID = new JLabel((String) null);
		memberID.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		memberID.setBounds(107, 51, 300, 40);
		panel_2_1_1.add(memberID);

		// 日期選擇器
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setPreferredSize(new Dimension(200, 30));
		dateChooser.setBounds(110, 255, 217, 40);
		panel_2_1_1.add(dateChooser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(412, 151, 458, 198);
		panel_2_1_1.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);

		JLabel age = new JLabel((String) null);
		age.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		age.setBounds(111, 347, 217, 40);
		panel_2_1_1.add(age);

		// 視窗設定
		Common.setWindows(this);

		JButton login = new JButton("儲存");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 將日期選擇器所選擇的日期，轉換成String
				Date selectedDate = dateChooser.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String sd = sdf.format(selectedDate);

				// 比較選擇器日期是否超過當前的日期
				if (Common.dateComparison(sd)) {

					try {
						member.setMemberName(membername.getText());
						member.setMemberEmail(memberemail.getText());
						member.setMemberPhone(phone.getText());
						member.setMemberBirthday(sd);
						member.setMemberGender(SexOpt);
						member.setMemberLocation(location.getText());
						member.setMemberIntroduction(textArea.getText());

						new MemberServiceImpl().updateMember(member.getId(), member);

						if (member != null) {
							JOptionPane.showMessageDialog(null, "儲存完成", "提示", JOptionPane.WARNING_MESSAGE);
						}

						Temp.saveFile(filePath, member);
						Member m3 = (Member) Temp.readFile(filePath);

					} catch (Exception e2) {
						e2.printStackTrace();
						JOptionPane.showMessageDialog(null, "儲存失敗", "提示", JOptionPane.WARNING_MESSAGE);
					}
				} else {

					JOptionPane.showMessageDialog(null, "日期不能超過今天!!", "提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		login.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		login.setBackground(Color.GREEN);
		login.setBounds(705, 389, 193, 42);
		panel_2_1_1.add(login);

		// =============畫面載入後預設顯示數據==================

		account.setText(member.getMemberAccount());
		memberID.setText(member.getMemberId());
		membername.setText(member.getMemberName());
		memberemail.setText(member.getMemberEmail());
		phone.setText(member.getMemberPhone());

		// 將日期格式進行轉換
		if (member.getMemberBirthday() != null) {
			DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(member.getMemberBirthday(), dateformat);
			Date date2 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()); // 網上找到將LocalDate轉換成Date的作法(待研究)
			dateChooser.setDate(date2); // 日期選擇器，要給Date類型
		}

		// 更新畫面顯示的年紀用
		Member m = new MemberServiceImpl().getMemberByUser(member.getMemberAccount());
		age.setText(m.getMemberAge());

		sexOpt.setSelectedItem(member.getMemberGender());
		location.setText(member.getMemberLocation());
		textArea.setText(member.getMemberIntroduction());

		// 1.在MemberStateServiceImpl 獲得會員所屬的clubid
		// 2.在ClubServiceImpl以clubid獲得社團名稱
		MemberState ms = new MemberStateServiceImpl().getClubByMember(member.getMemberId());
		Clubs club = null;

		if (ms != null) {
			club = new ClubsServiceImpl().getClubsByClubId(ms.getClubId());
		}

		// 查詢社團名稱
		if (club != null) {
			userclub.setText(club.getClubName());
		} else {
			userclub.setText("尚未加入任何社團");
		}
	}
}
