package controller.clubs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import controller.CommonUI;
import controller.model.ClubsListTableModel;
import model.Clubs;
import model.Member;
import model.MemberState;
import model.views.mangerbyclubinfo;
import service.Impl.MemberStateServiceImpl;
import service.Impl.MangerbyClubInfoServiceImpl;
import util.Common;
import util.Temp;

public class ClubsList2UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private Member member; // 儲存個人狀態用
	private Clubs club;
	private MemberState memberstate;
	private String sqlPath = "dbInfo.txt";
	private String filePath = "member.txt";
	private String clubPath = "club.txt";
	private String filePathofMemberState = "memberState.txt";

	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubsList2UI frame = new ClubsList2UI();
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
	public ClubsList2UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 1086, 633);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 1086, 68);
		panel.add(panel_3);

		// ---------表格內數據----------------------
		List<mangerbyclubinfo> list2 = new MangerbyClubInfoServiceImpl().getAllMember();
		ClubsListTableModel model = new ClubsListTableModel(list2);

		// -----加載temp資訊----------------------------------------------------------
		
		CommonUI.CookieData2();
		memberstate = CommonUI.memberstate;
		member = CommonUI.member;
		club = CommonUI.club;

		// ---------載入社團資訊-------------------------------------------------------

		// 判斷社團是否存在
//		MemberState ms = new MemberStateServiceImpl().getClubByMember(CommonUI.member.getMemberId());
//
//		// 社團資訊存在
//		if (ms != null) {
//			club = CommonUI.club;
//			memberstate = CommonUI.memberstate;
//		}
//
//		// 進行Clubs的空值檢查，並更新temp
//		if (club != null) {
//			System.out.println("\nClub ID: " + club.getClubId()); // 安全訪問getClubId
//			Temp.saveFile(clubPath, club); // 繼續將數據寫入檔案
//			Temp.saveFile(filePathofMemberState, memberstate);
//		} else {
//			System.out.println("獲取社團失敗，club為 null");
//		}

		// -----上方選單----------------------------------------------------------

		CommonUI.TopMenu(panel_3, this);

//		JPanel Top_panel = new JPanel();
//		Top_panel.setLayout(null);
//		Top_panel.setBounds(984, 10, 92, 48);
//		panel_3.add(Top_panel);
//
//		JLabel lblNewLabel = new JLabel("活動");
//		lblNewLabel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				EventListUI ui = new EventListUI();
//				ui.setVisible(true);
//				dispose();
//			}
//		});
//		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
//		lblNewLabel.setBounds(699, 14, 72, 38);
//		panel_3.add(lblNewLabel);
//
//		JLabel lblNewLabel_2 = new JLabel("社團");
//		lblNewLabel_2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				ClubsList2UI ui = new ClubsList2UI();
//				ui.setVisible(true);
//				dispose();
//			}
//		});
//		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
//		lblNewLabel_2.setBounds(795, 14, 72, 38);
//		panel_3.add(lblNewLabel_2);
//
//		JLabel lblNewLabel_2_1 = new JLabel("我的");
//		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				PersonEditUI ui = new PersonEditUI();
//				ui.setVisible(true);
//				dispose();
//
//			}
//		});
//		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
//		lblNewLabel_2_1.setBounds(890, 14, 72, 38);
//		panel_3.add(lblNewLabel_2_1);
//		
//		JLabel lblNewLabel_4 = new JLabel("New label");
//		lblNewLabel_4.setIcon(new ImageIcon(ClubsList2UI.class.getResource("/controller/img/blueshoes-logo3 (1).png")));
//		lblNewLabel_4.setBounds(21, 9, 264, 48);
//		panel_3.add(lblNewLabel_4);

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
//		CommonUI.SideMenu2(side_panel_1, this);
		

//		JButton clubEdit = new JButton("社團編輯");
//		clubEdit.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				ClubsEdit2UI ui = new ClubsEdit2UI();
//				ui.setVisible(true);
//				dispose();
//			}
//		});
//		clubEdit.setForeground(Color.BLACK);
//		clubEdit.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		clubEdit.setBackground(Color.WHITE);
//		clubEdit.setBounds(10, 173, 123, 30);
//		side_panel_1.add(clubEdit);
//		
//		JButton msgBoard = new JButton("留言板");
//		msgBoard.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				ClubsMsgBoardUI ui = new ClubsMsgBoardUI();
//				ui.setVisible(true);
//				dispose();
//			}
//		});
//		msgBoard.setForeground(Color.BLACK);
//		msgBoard.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		msgBoard.setBackground(Color.WHITE);
//		msgBoard.setBounds(10, 132, 123, 30);
//		side_panel_1.add(msgBoard);
//		
//		JButton myClub = new JButton("我的社團");
//		myClub.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				MyClubsUI ui = new MyClubsUI();
//				ui.setVisible(true);
//				dispose();
//			}
//		});
//		myClub.setForeground(Color.BLACK);
//		myClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		myClub.setBackground(Color.WHITE);
//		myClub.setBounds(10, 91, 123, 30);
//		side_panel_1.add(myClub);
//		
//		JButton memberofClub = new JButton("團員管理");
//		memberofClub.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				ClubsManageMemberUI ui = new ClubsManageMemberUI();
//				ui.setVisible(true);
//				dispose();
//				
//			}
//		});
//		memberofClub.setForeground(Color.BLACK);
//		memberofClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		memberofClub.setBackground(Color.WHITE);
//		memberofClub.setBounds(10, 214, 123, 30);
//		side_panel_1.add(memberofClub);
//		
//		JButton unknow = new JButton("暫定");
//		unknow.setForeground(Color.BLACK);
//		unknow.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		unknow.setBackground(Color.WHITE);
//		unknow.setBounds(10, 253, 123, 30);
//		side_panel_1.add(unknow);

		// --登入資訊--------------

		CommonUI.userInfo(side_panel_1, member);

//		JLabel memberName_1 = new JLabel("張三豐");
//		memberName_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		memberName_1.setBounds(10, 10, 121, 30);
//		side_panel_1.add(memberName_1);
//		memberName_1.setText(member.getMemberName());
//		
//		
//		JLabel memberId_1 = new JLabel("ID: XXXXXXX");
//		memberId_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		memberId_1.setBounds(10, 39, 121, 30);
//		side_panel_1.add(memberId_1);
//		memberId_1.setText("ID:"+member.getMemberId());

		// --登出離開------------------------

		CommonUI.exitMenu(side_panel_1, this);

//		JButton register_1 = new JButton("登出");
//		register_1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				String msg1 = "你是否要登出帳號?";
//				String msg2 = "登出帳號";
//
//				CommonUI.twoOption(msg1, msg2, () -> {
////					member = null;
////					club = null;
//					JOptionPane.showMessageDialog(null, "成功登出帳號。", msg2, JOptionPane.WARNING_MESSAGE);
////					FiletReadandSave.saveFile(filePath, member);
//					LoginUI ui = new LoginUI();
//					ui.setVisible(true);
//					dispose();
//				});
//				
//			}
//		});
//		register_1.setForeground(Color.WHITE);
//		register_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		register_1.setBackground(Color.BLUE);
//		register_1.setBounds(8, 451, 123, 30);
//		side_panel_1.add(register_1);
//		
//		JButton register = new JButton("離開程式");
//		register.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				String msg1 = "你是否要離開這個程式?";
//				String msg2 = "離開程式";
////				member = null;
////				club = null;
//				CommonUI.twoOption(msg1, msg2, () -> dispose());
////				FiletReadandSave.saveFile(filePath, member);
//			}
//		});
//		register.setForeground(Color.WHITE);
//		register.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		register.setBackground(Color.BLUE);
//		register.setBounds(8, 491, 123, 30);
//		side_panel_1.add(register);

		// -----登入資訊----------------------------------------------------

//		JLabel memberName = new JLabel((String) null);
//		memberName.setBounds(10, 10, 121, 30);
//		side_panel_1.add(memberName);
//		memberName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//
//		JLabel memberId = new JLabel((String) null);
//		memberId.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
//		memberId.setBounds(10, 39, 121, 30);
//		side_panel_1.add(memberId);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(159, 69, 927, 554);
		panel.add(panel_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(9, 7, 908, 65);
		panel_1_1.add(panel_3_1);

		JLabel lblNewLabel_3 = new JLabel("社團清單");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 132, 42);
		panel_3_1.add(lblNewLabel_3);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1.setBounds(10, 84, 907, 460);
		panel_1_1.add(panel_2_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 907, 460);
		panel_2_1.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("※連續點擊2下任一個社團，可加入");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 553, 29);
		panel_2.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 49, 860, 378);
		panel_2.add(scrollPane);

		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) { // 雙擊才會觸發加入社團

					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow(); // 獲取選中的行

					// 獲取選中行的社團ID
					String clubId = table.getModel().getValueAt(row, 0).toString(); // 捕捉社團id是第一列時的數據

					member = CommonUI.member; // 外面有放了 但沒抓到(待研究)
//					System.out.println(member.getMemberId());

					// 檢查是否已經是其他社團的成員或團長
					boolean isClubLeader = new MemberStateServiceImpl().getUsetIsClubLeader(member);
					boolean isClubMember = new MemberStateServiceImpl().getUsetIsClubmember(member);
//					System.out.println("isClubLeader-"+isClubLeader);
//					System.out.println("isClubMember-"+isClubMember);

					if (isClubLeader) {
						JOptionPane.showMessageDialog(null, "你已經是團長，無法加入其他社團。", "提示", JOptionPane.WARNING_MESSAGE);
					} else if (isClubMember) {
						JOptionPane.showMessageDialog(null, "你已經是一個社團的成員，無法加入其他社團。", "提示", JOptionPane.WARNING_MESSAGE);
					} else {

						// 呼叫方法加入社團
						String msg1 = "你是否要加入這個社團?";
						String msg2 = "加入社團";

						CommonUI.twoOption(msg1, msg2, () -> {

							memberstate.setMemberId(member.getMemberId());
							new MemberStateServiceImpl().joinClub(memberstate, clubId);

//							Temp.saveFile(filePath, member);
//							Temp.saveFile(clubPath, club);
							Temp.saveFile(filePathofMemberState, memberstate);

							JOptionPane.showMessageDialog(null, "你已成功加入社團！", "成功", JOptionPane.INFORMATION_MESSAGE);
							MyClubsUI ui = new MyClubsUI();
							ui.setVisible(true);
							dispose();

						});
					}
				}
			}
		});
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		scrollPane.setViewportView(table);

		JButton register_1_1_1 = new JButton("創建社團");
		register_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

//				if (club != null) {
//					System.out.println("裡面有東西!!!");
//
//				} else {
//
//					System.out.println("club是空的");
//				}
//
//				if(ms!= null) {
//					System.out.println("@--"+ms.getClubId());
//					Clubs club1 = new ClubsServiceImpl().getClubsByClubId(ms.getClubId());
//					String club2 = club1.getClubName();
//				}
//				System.out.println("-------------------\n" + ms);
//				
//				System.out.println(club);
//
//				String club = new ClubsDaoImpl().queryClubName(member.getClubID()); // 查詢社團名稱(秀出社團名稱用)

				// 檢查是否已經是其他社團的成員或團長
				boolean isClubMember = new MemberStateServiceImpl().getUsetIsClubmember(member);
				boolean isClubLeader = new MemberStateServiceImpl().getUsetIsClubLeader(member);

//				System.out.println("團長=>" + isClubLeader);
//				System.out.println("團員=>" + isClubMember);

				if (isClubLeader) {

					JOptionPane.showMessageDialog(null, "你已經是【" + club.getClubName() + "】的團長，無法再創建其他社團。", "提示",
							JOptionPane.WARNING_MESSAGE);

				} else if (isClubMember) {

					JOptionPane.showMessageDialog(null, "你已經加入【" + club.getClubName() + "】，無法創建其他社團。", "提示",
							JOptionPane.WARNING_MESSAGE);

				} else {

					ClubsCreadit2UI ui = new ClubsCreadit2UI();
					ui.setVisible(true);
					dispose();
				}
			}
		});
		register_1_1_1.setForeground(Color.BLACK);
		register_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		register_1_1_1.setBackground(Color.GREEN);
		register_1_1_1.setBounds(757, 10, 123, 42);
		panel_3_1.add(register_1_1_1);

		// 設置table表格欄位寬度
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
				column.setPreferredWidth(100);
				break;
			default:
				column.setPreferredWidth(30);
				break;
			}
		}
	}
}
