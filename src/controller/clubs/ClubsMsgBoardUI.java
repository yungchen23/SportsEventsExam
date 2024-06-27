package controller.clubs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import controller.CommonUI;
import controller.model.MyMsgListTableModel;
import model.Clubs;
import model.Member;
import model.MemberState;
import model.views.myMsglist;
import service.Impl.ClubsServiceImpl;
import service.Impl.MyMsglistServiceImpl;
import util.Common;

public class ClubsMsgBoardUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;
	private MemberState memberstate;
	private Member member; // 儲存個人狀態用
	private Clubs club;
	private String sqlPath = "dbInfo.txt";
	private String filePath = "member.txt";
	private String clubPath = "club.txt";
	private String filePathofMemberState = "memberState.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubsMsgBoardUI frame = new ClubsMsgBoardUI();
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
	public ClubsMsgBoardUI() {
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

		// ---------表格內數據----------------------

		List<myMsglist> list2 = null;

		Clubs c = new ClubsServiceImpl().getClubsByClubId(memberstate.getClubId());
		if (c != null) {
			String clubid = c.getClubId();
			list2 = new MyMsglistServiceImpl().getMsgbyClubs(clubid);
		} else {
			list2 = new MyMsglistServiceImpl().getMsgbyClubs("");
		}

		MyMsgListTableModel model = new MyMsgListTableModel(list2);
		


		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(159, 69, 927, 554);
		panel.add(panel_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(9, 7, 908, 65);
		panel_1_1.add(panel_3_1);

		JLabel lblNewLabel_3 = new JLabel("留言板");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 132, 42);
		panel_3_1.add(lblNewLabel_3);

		JButton printerBTN = new JButton("我要留言");
		printerBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ClubsPostMsgUI ui = new ClubsPostMsgUI();
				ui.setVisible(true);
				dispose();

			}
		});
		printerBTN.setForeground(Color.WHITE);
		printerBTN.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		printerBTN.setBackground(new Color(64, 0, 64));
		printerBTN.setBounds(775, 20, 123, 32);
		panel_3_1.add(printerBTN);

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
		scrollPane.setBounds(30, 27, 322, 405);
		panel_2_1_1.add(scrollPane);

		

		JLabel lblNewLabel_1_2 = new JLabel("留言內容");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(385, 155, 86, 15);
		panel_2_1_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("發表人");
		lblNewLabel_1_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(385, 40, 86, 15);
		panel_2_1_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("發表時間");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(385, 96, 86, 15);
		panel_2_1_1.add(lblNewLabel_1_1);
		
		JLabel username = new JLabel((String) null);
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		username.setBounds(465, 28, 419, 40);
		panel_2_1_1.add(username);
		
		JLabel date = new JLabel((String) null);
		date.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		date.setBounds(465, 86, 419, 40);
		panel_2_1_1.add(date);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(384, 180, 500, 252);
		panel_2_1_1.add(scrollPane_1);
		
		JTextArea msgBoard = new JTextArea();
		msgBoard.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		msgBoard.setEnabled(false);
		scrollPane_1.setViewportView(msgBoard);
		

		
		// 邊框加顏色
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
		date.setBorder(border);
		username.setBorder(border);
		
		table = new JTable(model);
		// 加入選擇監聽器
		table.getSelectionModel().addListSelectionListener(event -> {
			int viewRow = table.getSelectedRow(); // 獲取選中的行
			if (viewRow >= 0) {
				username.setText(table.getValueAt(viewRow, 1).toString());
				date.setText(table.getValueAt(viewRow, 3).toString());
				msgBoard.setText(table.getValueAt(viewRow, 2).toString());
			}
		});
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		// 視窗設定
		Common.setWindows(this);
		
		// 設置table欄位寬度
		setColumnWidths(table);
		
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
