package controller.clubs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CommonUI;
import controller.model.MyClubMemberListTableModel;
import dao.Impl.MemberStateDaoImpl;
import model.Clubs;
import model.Member;
import model.MemberState;
import model.views.getclubofmember;
import service.Impl.MemberServiceImpl;
import service.Impl.MemberStateServiceImpl;
import service.Impl.GetclubofmemberServiceImpl;
import util.Common;

public class ClubsManageMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;
	private String LevelOpt; // 等級combobox用
	private Member member; // 儲存個人狀態用
	private Clubs club;
	private MemberState memberstate;
	private String sqlPath = "dbInfo.txt";
	private String filePath = "member.txt";
	private String clubPath = "club.txt";
	private String filePathofMemberState = "memberState.txt";

	private List<getclubofmember> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClubsManageMemberUI frame = new ClubsManageMemberUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public ClubsManageMemberUI() {
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

		// ---------表格內數據----------------------

//		List<getclubofmember> list=null;
		list = new GetclubofmemberServiceImpl().getMemberbyClub(club.getClubId());
		MyClubMemberListTableModel model = new MyClubMemberListTableModel(list);

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

		// 建立邊框
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(159, 69, 927, 554);
		panel.add(panel_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(9, 7, 908, 65);
		panel_1_1.add(panel_3_1);

		JLabel lblNewLabel_3 = new JLabel("團員管理");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 132, 42);
		panel_3_1.add(lblNewLabel_3);

//		JButton printerBTN = new JButton("發布通知");
//		printerBTN.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				ClubsPostNoticeUI ui = new ClubsPostNoticeUI();
//				ui.setVisible(true);
//				dispose();
//				
//			}
//		});
//		printerBTN.setForeground(Color.WHITE);
//		printerBTN.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		printerBTN.setBackground(new Color(64, 0, 64));
//		printerBTN.setBounds(775, 25, 123, 32);
//		panel_3_1.add(printerBTN);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1_1.setBounds(9, 82, 908, 462);
		panel_1_1.add(panel_2_1_1);

		JLabel lblNewLabel_4 = new JLabel("社團名稱");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(24, 10, 85, 40);
		panel_2_1_1.add(lblNewLabel_4);

		JLabel clubName = new JLabel((String) null);
		clubName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubName.setBounds(108, 10, 227, 40);
		panel_2_1_1.add(clubName);
		clubName.setBorder(border);

		JLabel lblNewLabel_4_1 = new JLabel("社團ID");
		lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(25, 61, 85, 40);
		panel_2_1_1.add(lblNewLabel_4_1);

		JLabel clubID = new JLabel((String) null);
		clubID.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubID.setBounds(109, 61, 227, 40);
		panel_2_1_1.add(clubID);
		clubID.setBorder(border);

		JLabel lblNewLabel_4_2 = new JLabel("社團成員");
		lblNewLabel_4_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_2.setBounds(24, 116, 85, 40);
		panel_2_1_1.add(lblNewLabel_4_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 166, 311, 274);
		panel_2_1_1.add(scrollPane);

		JLabel lblNewLabel_4_3 = new JLabel("稱謂");
		lblNewLabel_4_3.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_3.setBounds(399, 185, 85, 40);
		panel_2_1_1.add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_1_1 = new JLabel("團員名稱");
		lblNewLabel_4_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_1_1.setBounds(401, 124, 85, 40);
		panel_2_1_1.add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_4_1_1_1 = new JLabel("團員等級");
		lblNewLabel_4_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_1_1_1.setBounds(400, 261, 85, 40);
		panel_2_1_1.add(lblNewLabel_4_1_1_1);

		JLabel usermember = new JLabel("未選取");
		usermember.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		usermember.setBounds(486, 124, 217, 40);
		panel_2_1_1.add(usermember);
		usermember.setBorder(border);

		JLabel usertitle = new JLabel("未選取");
		usertitle.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		usertitle.setBounds(484, 185, 217, 40);
		panel_2_1_1.add(usertitle);
		usertitle.setBorder(border);

		// ------下拉選單------------------------------------------

		JComboBox levelOpt = new JComboBox();
		levelOpt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object opt = levelOpt.getSelectedItem();
				LevelOpt = (String) opt;
			}
		});
		levelOpt.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3" }));
		levelOpt.setSelectedIndex(0);
		levelOpt.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		levelOpt.setBounds(485, 261, 217, 40);
		panel_2_1_1.add(levelOpt);

		JButton addNewClub = new JButton("儲存");
		addNewClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int viewRow = table.getSelectedRow(); // 獲得選擇的行
				String lvl = table.getValueAt(viewRow, 2).toString(); // 選中的等級
				String username = table.getValueAt(viewRow, 0).toString();// 選中的團員名稱
				String title = table.getValueAt(viewRow, 1).toString();// 選中的團員頭銜

				// 1.先獲取團員名字
				String membername = usermember.getText(); // 獲取團員名字
				Member m = new MemberServiceImpl().getMemberByUser2(membername);

				System.out.println("方法內===username+>" + lvl);
				System.out.println("方法內===LevelOpt+>" + LevelOpt);

				if (title.equals("團長")) { // 判斷團長等級無法修改

					JOptionPane.showMessageDialog(null, "團長等級無法修改，儲存失敗", "提示", JOptionPane.WARNING_MESSAGE);

				} else {

					if (lvl.equals(LevelOpt)) { // 判斷等級沒有變更修改

						System.out.println("等級沒有改動");
						JOptionPane.showMessageDialog(null, "未設定等級，儲存失敗", "提示", JOptionPane.WARNING_MESSAGE);

					} else {

						// 2.修改Level狀態
						MemberState ms = new MemberStateServiceImpl().getClubByMember(m.getMemberId()); // 從團員ID(memberId)獲取
						ms.setLevel(LevelOpt);
						new MemberStateDaoImpl().updateLevel(ms);
						JOptionPane.showMessageDialog(null, "儲存完成", "提示", JOptionPane.WARNING_MESSAGE);

					}
				}
			}
		});
		addNewClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		addNewClub.setBackground(Color.GREEN);
		addNewClub.setBounds(502, 398, 193, 42);
		panel_2_1_1.add(addNewClub);

		JButton cancel = new JButton("取消");
		cancel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		cancel.setBackground(Color.GREEN);
		cancel.setBounds(705, 398, 193, 42);
		panel_2_1_1.add(cancel);

		table = new JTable(model);
		table.getSelectionModel().addListSelectionListener(event -> {

			int viewRow = table.getSelectedRow(); // 獲取選中的行

			if (viewRow >= 0) {
				usermember.setText(table.getValueAt(viewRow, 0).toString()); // 團員名字
				usertitle.setText(table.getValueAt(viewRow, 1).toString()); // 團員稱謂
				levelOpt.setSelectedItem(table.getValueAt(viewRow, 2).toString()); // 團員等級
			}
		});
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		// 視窗設定
		Common.setWindows(this);

		// =============畫面載入後預設顯示數據==================
		clubName.setText(club.getClubName());
		clubID.setText(club.getClubId());

		JButton btnNewButton = new JButton("查看權限");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ClubsRoleUI ui = new ClubsRoleUI();
				ui.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnNewButton.setBounds(720, 261, 119, 40);
		panel_2_1_1.add(btnNewButton);

	}
}
