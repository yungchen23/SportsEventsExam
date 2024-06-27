package controller.member;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import controller.CommonUI;
import controller.model.MyNoticeListTableModel;
import model.Clubs;
import model.Events;
import model.Member;
import model.MemberState;
import model.views.myNoticelist;
import service.Impl.ClubsServiceImpl;
import service.Impl.MyNoticelistServiceImpl;
import util.Common;

public class MyNoticeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;
	//儲存狀態用
	private Member member; 
	private Clubs club;
	private MemberState memberstate;
	private Events event;
	private String sqlPath = "dbInfo.txt";
	private String filePath = "member.txt";
	private String clubPath = "club.txt";
	private String filePathofMemberState = "memberState.txt";
	private String filePathofEvent = "events.txt";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyNoticeUI frame = new MyNoticeUI();
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
	public MyNoticeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 1086, 633);
		contentPane.add(panel);
		panel.setLayout(null);

		// -----加載temp資訊----------------------------------------------------------
		
		
		CommonUI.CookieData2();
		memberstate = CommonUI.memberstate;
		member = CommonUI.member;
		club = CommonUI.club;

		// ---------表格內數據----------------------

		List<myNoticelist> list2 = null;
		
		Clubs c = new ClubsServiceImpl().getClubsByClubId(memberstate.getClubId());
		if (c != null) {
			String author = c.getClubName();
			list2 = new MyNoticelistServiceImpl().getNoticebyClubs(author);
		} else {
			list2 = new MyNoticelistServiceImpl().getNoticebyClubs("");
		}

		MyNoticeListTableModel model = new MyNoticeListTableModel(list2);

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

		JLabel title = new JLabel("我的通知");
		title.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		title.setBounds(10, 10, 132, 42);
		panel_3_1.add(title);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1_1.setBounds(9, 82, 908, 462);
		panel_1_1.add(panel_2_1_1);

		JLabel clubName = new JLabel((String) null);
		clubName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubName.setBounds(108, 10, 227, 40);
		panel_2_1_1.add(clubName);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 24, 394, 405);
		panel_2_1_1.add(scrollPane);

		// 邊框加顏色
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);

		JLabel lblNewLabel_1_2 = new JLabel("主旨");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(455, 27, 86, 15);
		panel_2_1_1.add(lblNewLabel_1_2);

		JLabel notice = new JLabel("             目前沒有任何內容");
		notice.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		notice.setBounds(455, 212, 423, 220);
		panel_2_1_1.add(notice);
		notice.setBorder(border);

		JLabel subject = new JLabel("");
		subject.setBackground(new Color(128, 255, 255));
		subject.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		subject.setBounds(455, 52, 423, 41);
		panel_2_1_1.add(subject);
		subject.setBorder(border);

		JLabel lblNewLabel_1_2_1 = new JLabel("通知內容");
		lblNewLabel_1_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(455, 187, 86, 15);
		panel_2_1_1.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("通知時間");
		lblNewLabel_1_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(455, 103, 86, 15);
		panel_2_1_1.add(lblNewLabel_1_2_2);

		JLabel ptime = new JLabel((String) null);
		ptime.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		ptime.setBackground(new Color(128, 255, 255));
		ptime.setBounds(455, 128, 423, 41);
		panel_2_1_1.add(ptime);
		ptime.setBorder(border);

		// ---------表格內數據----------------------

//        table = new JTable();
		table = new JTable(model);
		// 加入選擇監聽器
		table.getSelectionModel().addListSelectionListener(event -> {
			int viewRow = table.getSelectedRow(); // 獲取選中的行
			if (viewRow >= 0) {
				subject.setText(table.getValueAt(viewRow, 2).toString());
				ptime.setText(table.getValueAt(viewRow, 3).toString());
				notice.setText(table.getValueAt(viewRow, 4).toString());
			}
		});

		table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		// 設置table欄位寬度
		setColumnWidths(table);

		// 視窗設定
		Common.setWindows(this);
	}

	private void setColumnWidths(JTable table) {
		TableColumn column;
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			switch (i) {
			case 0:
				column.setPreferredWidth(30);
				break;
			case 1:
				column.setPreferredWidth(100);
				break;
			case 2:
				column.setPreferredWidth(100);
				break;
			case 3:
				column.setPreferredWidth(100);
				break;
			case 4:
				column.setPreferredWidth(0);
				break;
			default:
				column.setPreferredWidth(100);
				break;
			}
		}
	}
}
