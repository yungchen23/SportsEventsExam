package controller.clubs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CommonUI;
import model.Clubs;
import model.Member;
import model.MemberState;
import service.Impl.ClubsServiceImpl;
import service.Impl.MemberStateServiceImpl;
import util.Common;
import util.Temp;

public class ClubsCreadit2UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField clubName;
	private Member member; // 儲存個人狀態用
	private Clubs club;
	private MemberState memberstate;
	private String sqlPath = "dbInfo.txt";
	private String filePath = "member.txt";
	private String clubPath = "club.txt";
	private String filePathofMemberState = "memberState.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	public ClubsCreadit2UI() {
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
		memberstate = CommonUI.memberstate;
		member = CommonUI.member;
		club = CommonUI.club;

		// -----上方選單----------------------------------------------------------

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 1086, 68);
		panel.add(panel_3);

		CommonUI.TopMenu(panel_3, this);

		// -----側邊選單(Club)----------------------------------------------------

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 69, 139, 554);
		panel.add(panel_1);

		JPanel side_panel_1 = new JPanel();
		side_panel_1.setLayout(null);
		side_panel_1.setBounds(0, 0, 139, 554);
		panel_1.add(side_panel_1);

		CommonUI.SideMenu(side_panel_1, this);

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

		JLabel lblNewLabel_3 = new JLabel("創建社團");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 132, 42);
		panel_3_1.add(lblNewLabel_3);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1_1.setBounds(9, 83, 908, 449);
		panel_1_1.add(panel_2_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("社團名稱");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(21, 35, 85, 15);
		panel_2_1_1.add(lblNewLabel_2_2);

		clubName = new JTextField();
		clubName.setText((String) null);
		clubName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubName.setColumns(10);
		clubName.setBounds(107, 22, 393, 40);
		panel_2_1_1.add(clubName);

		JLabel lblNewLabel_1 = new JLabel("社團介紹");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 96, 86, 15);
		panel_2_1_1.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 94, 393, 182);
		panel_2_1_1.add(scrollPane);

		JTextArea clubDesic = new JTextArea();
		scrollPane.setViewportView(clubDesic);
		clubDesic.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

		JButton addNewClub = new JButton("創建");
		addNewClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String ClubName = clubName.getText();
				String ClubDescription = clubDesic.getText();
				Clubs nClub = null; // 新建社團
				String cid = null; // 暫存clubId用

				MemberState nMemberstate = null; // 新建社團的狀態
				nClub = new ClubsServiceImpl().getClubsByName(ClubName); // 檢查社團名稱重複

				if (ClubName.isEmpty()) {

					JOptionPane.showMessageDialog(null, "社團名稱不能留空白", "提示", JOptionPane.WARNING_MESSAGE);

				} else {

					if (nClub != null) {

						JOptionPane.showMessageDialog(null, "此社團名稱已存在，請重新輸入", "提示", JOptionPane.WARNING_MESSAGE);

					} else {

						nClub = new Clubs(null, ClubName, member.getMemberId(), ClubDescription, null, null, null, null);
						new ClubsServiceImpl().addClubs(nClub); // 完成，有存在


						Clubs nClub2 = new ClubsServiceImpl().getClubsByName(ClubName);

						memberstate = new MemberState(member.getMemberId(), null, null, null, null, null, null);
						new MemberStateServiceImpl().createClub(memberstate, nClub2);

						Temp.saveFile(ClubName, club);
						Temp.saveFile(filePathofMemberState, memberstate);
						JOptionPane.showMessageDialog(null, "社團創建成功", "提示", JOptionPane.WARNING_MESSAGE);

						ClubsList2UI ui = new ClubsList2UI();
						ui.setVisible(true);
						dispose();
						
					}
				}
			}
		});
		addNewClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		addNewClub.setBackground(Color.GREEN);
		addNewClub.setBounds(502, 397, 193, 42);
		panel_2_1_1.add(addNewClub);

		JButton cancel = new JButton("取消");
		cancel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		cancel.setBackground(Color.GREEN);
		cancel.setBounds(705, 397, 193, 42);
		panel_2_1_1.add(cancel);

		// 視窗設定
		Common.setWindows(this);
	}
}
