package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controller.clubs.ClubsEdit2UI;
import controller.clubs.ClubsList2UI;
import controller.clubs.ClubsManageMemberUI;
import controller.clubs.ClubsMsgBoardUI;
import controller.clubs.ClubsPostNoticeUI;
import controller.clubs.MyClubsUI;
import controller.events.EventExpiredListUI;
import controller.events.EventListUI;
import controller.events.EventUI;
import controller.member.ChagerPasswordUI;
import controller.member.MyNoticeUI;
import controller.member.PersonEditUI;
import model.Clubs;
import model.EventClub;
import model.Events;
import model.Member;
import model.MemberState;
import service.Impl.ClubsServiceImpl;
import service.Impl.MemberStateServiceImpl;
import util.ExitApp;
import util.Temp;

public class CommonUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// 儲存狀態用
	public static Member member;
	public static Clubs club;
	public static Events event;
	public static MemberState memberstate;
	public static EventClub eventClub;
	// 文件路徑
	private static String clubPath = "club.txt";
	private static String filePathofMemberState = "memberState.txt";
	private static String sqlPath = "dbInfo.txt";
	private static String filePath = "member.txt";
	private static String filePathofEvent = "events.txt";
	private static String filePathofEventClub = "eventclub.txt";
	private static String memberLv = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommonUI frame = new CommonUI();
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
	public CommonUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

	public static void CookieData2() {

		Object obj = Temp.readFile(filePath);
		member = (Member) obj;
		
		Object obj2 = Temp.readFile(filePathofEventClub);
		eventClub = (EventClub) obj2;
		

		// 1.先載入Clubs 和 MemberState 確認存在
		memberstate = new MemberStateServiceImpl().getClubByMember(member.getMemberId());

		if (memberstate != null) {
			club = new ClubsServiceImpl().getClubsByClubId(memberstate.getClubId());
			Temp.saveFile(filePathofMemberState, memberstate);
			Temp.saveFile(clubPath, club);

		} else {
			club = new Clubs();
			memberstate = new MemberState();
			Temp.saveFile(filePathofMemberState, memberstate);
			Temp.saveFile(clubPath, club);

		}
	}

	public static void CookieData() {

		/* Clubs */ club = null;
		// 儲存Club狀態用
		/* MemberState */ memberstate = null; // 儲存MemberState狀態用

		Object obj = Temp.readFile(filePath);
		member = (Member) obj;

		// 1.先載入Clubs 和 MemberState 確認存在
		memberstate = new MemberStateServiceImpl().getClubByMember(member.getMemberId());

		if (memberstate != null) {
			club = new ClubsServiceImpl().getClubsByClubId(memberstate.getClubId());
		} else {
			club = new Clubs();
			memberstate = new MemberState();
		}

		// 載入Clubs的資訊

		System.out.println("1commonUI-社團-" + club.getClubId());
		System.out.println("1commonUI-社團-" + memberstate.getMemberId());


		Object obj2 = Temp.readFile(clubPath);
		club = (Clubs) obj2;

		Object obj3 = Temp.readFile(filePathofMemberState);
		memberstate = (MemberState) obj3;

		Object obj4 = Temp.readFile(filePathofEvent);
		event = (Events) obj4;

	}

	// -------Top選單----------------------------------------------------------------
	public static void TopMenu(JPanel panel, Window window) {

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(ClubsList2UI.class.getResource("/controller/img/blueshoes-logo3 (1).png")));
		lblNewLabel_4.setBounds(21, 9, 264, 48);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("活動");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EventUI ui = new EventUI();
				ui.setVisible(true);
				window.dispose();
			}
		});
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(699, 14, 72, 38);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("社團");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ClubsList2UI ui = new ClubsList2UI();
				ui.setVisible(true);
				window.dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(795, 14, 72, 38);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("我的");
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PersonEditUI ui = new PersonEditUI();
				ui.setVisible(true);
				window.dispose();

			}
		});
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(890, 14, 72, 38);
		panel.add(lblNewLabel_2_1);
	}

	public static void SideMenu(JPanel panel, Window window) {

		// 檢查是否已經是其他社團的成員或團長
		boolean isClubLeader = new MemberStateServiceImpl().getUsetIsClubLeader(member);
		boolean isClubMember = new MemberStateServiceImpl().getUsetIsClubmember(member);
		// 查團員等級
		memberLv = null;
		MemberState ms = new MemberStateServiceImpl().getClubByMember(memberstate.getMemberId());

		if (ms != null) {
			memberLv = ms.getLevel();
			System.out.println("1memberLv--" + memberLv);
		}

		JButton myClub = new JButton("我的社團");
		myClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (isClubLeader || isClubMember) {
					MyClubsUI ui = new MyClubsUI();
					ui.setVisible(true);
					window.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "你要先加入社團才能進入唷!!", "登入提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		myClub.setForeground(Color.BLACK);
		myClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		myClub.setBackground(Color.WHITE);
		myClub.setBounds(10, 91, 123, 30);
		panel.add(myClub);

		JButton msgBoard = new JButton("留言板");
		msgBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (isClubLeader || isClubMember) {

					ClubsMsgBoardUI ui = new ClubsMsgBoardUI();
					ui.setVisible(true);
					window.dispose();

				} else {

					JOptionPane.showMessageDialog(null, "這是社團專屬的留言板，你要先加入社團才能進入唷!!", "登入提示",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		msgBoard.setForeground(Color.BLACK);
		msgBoard.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		msgBoard.setBackground(Color.WHITE);
		msgBoard.setBounds(10, 132, 123, 30);
		panel.add(msgBoard);

		JButton clubEdit = new JButton("社團編輯");
		clubEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (isClubLeader || (memberLv != null && memberLv.equals("3"))) {

					ClubsEdit2UI ui = new ClubsEdit2UI();
					ui.setVisible(true);
					window.dispose();

				} else {

					JOptionPane.showMessageDialog(null, "你的權限不足，請洽團長喔!!", "登入提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		clubEdit.setForeground(Color.BLACK);
		clubEdit.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubEdit.setBackground(Color.WHITE);
		clubEdit.setBounds(10, 173, 123, 30);
		panel.add(clubEdit);

		JButton memberofClub = new JButton("團員管理");
		memberofClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (isClubLeader || (memberLv != null && memberLv.equals("3"))) {

					ClubsManageMemberUI ui = new ClubsManageMemberUI();
					ui.setVisible(true);
					window.dispose();

				} else {

					JOptionPane.showMessageDialog(null, "你的權限不足，請洽團長喔!!", "登入提示", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		memberofClub.setForeground(Color.BLACK);
		memberofClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		memberofClub.setBackground(Color.WHITE);
		memberofClub.setBounds(10, 214, 123, 30);
		panel.add(memberofClub);

		JButton postMsg = new JButton("發布通知");
		postMsg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (isClubLeader || (memberLv != null && memberLv.equals("3"))) {

					ClubsPostNoticeUI ui = new ClubsPostNoticeUI();
					ui.setVisible(true);
					window.dispose();

				} else {

					JOptionPane.showMessageDialog(null, "你的權限不足，請洽團長喔!!", "登入提示", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		postMsg.setForeground(Color.BLACK);
		postMsg.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		postMsg.setBackground(Color.WHITE);
		postMsg.setBounds(10, 253, 123, 30);
		panel.add(postMsg);
	}

	public static void SideMenuMember(JPanel panel, Window window) {

		JButton clubEdit = new JButton("修改密碼");
		clubEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ChagerPasswordUI ui = new ChagerPasswordUI();
				ui.setVisible(true);
				window.dispose();
			}
		});
		clubEdit.setForeground(Color.BLACK);
		clubEdit.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubEdit.setBackground(Color.WHITE);
		clubEdit.setBounds(10, 173, 123, 30);
		panel.add(clubEdit);

		JButton msgBoard = new JButton("我的通知");
		msgBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MyNoticeUI ui = new MyNoticeUI();
				ui.setVisible(true);
				window.dispose();
			}
		});
		msgBoard.setForeground(Color.BLACK);
		msgBoard.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		msgBoard.setBackground(Color.WHITE);
		msgBoard.setBounds(10, 132, 123, 30);
		panel.add(msgBoard);

		JButton myClub = new JButton("個人資訊");
		myClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				PersonEditUI ui = new PersonEditUI();
				ui.setVisible(true);
				window.dispose();
			}
		});
		myClub.setForeground(Color.BLACK);
		myClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		myClub.setBackground(Color.WHITE);
		myClub.setBounds(10, 91, 123, 30);
		panel.add(myClub);

		JButton memberofClub = new JButton("暫定");
		memberofClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		memberofClub.setForeground(Color.BLACK);
		memberofClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		memberofClub.setBackground(Color.WHITE);
		memberofClub.setBounds(10, 214, 123, 30);
		panel.add(memberofClub);

		JButton unknow = new JButton("暫定");
		unknow.setForeground(Color.BLACK);
		unknow.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		unknow.setBackground(Color.WHITE);
		unknow.setBounds(10, 253, 123, 30);
		panel.add(unknow);

	}

	public static void SideMenuEvent(JPanel panel, Window window) {

		JButton register_1_2_1 = new JButton("已過期");
		register_1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EventExpiredListUI ui = new EventExpiredListUI();
				ui.setVisible(true);
				window.dispose();

			}
		});
		register_1_2_1.setForeground(new Color(0, 0, 0));
		register_1_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		register_1_2_1.setBackground(new Color(255, 255, 255));
		register_1_2_1.setBounds(10, 132, 123, 30);
		panel.add(register_1_2_1);

		JButton register_1_2_1_1 = new JButton("進行中");
		register_1_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EventListUI ui = new EventListUI();
				ui.setVisible(true);
				window.dispose();
			}
		});
		register_1_2_1_1.setForeground(new Color(0, 0, 0));
		register_1_2_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		register_1_2_1_1.setBackground(new Color(255, 255, 255));
		register_1_2_1_1.setBounds(10, 91, 123, 30);
		panel.add(register_1_2_1_1);

		JButton register_1_2_1_1_1_1 = new JButton("暫定");
		register_1_2_1_1_1_1.setForeground(Color.BLACK);
		register_1_2_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		register_1_2_1_1_1_1.setBackground(Color.WHITE);
		register_1_2_1_1_1_1.setBounds(10, 214, 123, 30);
		panel.add(register_1_2_1_1_1_1);

		JButton register_1_2_1_1_1 = new JButton("暫定");
		register_1_2_1_1_1.setForeground(new Color(0, 0, 0));
		register_1_2_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		register_1_2_1_1_1.setBackground(new Color(255, 255, 255));
		register_1_2_1_1_1.setBounds(10, 173, 123, 30);
		panel.add(register_1_2_1_1_1);

	}

	public static void twoOption(String msg1, String msg2, ExitApp exit) {

		SwingUtilities.invokeLater(() -> {
			// 顯示對話框
			int result = JOptionPane.showConfirmDialog(null, msg1, msg2, JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			// member選擇操作的選項
			if (result == JOptionPane.YES_OPTION) {
				exit.logout();

			} else if (result == JOptionPane.NO_OPTION) {
				System.out.println("");
			}
		});
	}

	public static void exitMenu(JPanel panel, Window window) {

		JButton register_1 = new JButton("登出");
		register_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String msg1 = "你是否要登出帳號?";
				String msg2 = "登出帳號";

				CommonUI.twoOption(msg1, msg2, () -> {
					member = null;
					club = null;

					JOptionPane.showMessageDialog(null, "成功登出帳號。", msg2, JOptionPane.WARNING_MESSAGE);
					LoginUI ui = new LoginUI();
					ui.setVisible(true);
					window.dispose();
				});
			}
		});
		register_1.setForeground(Color.WHITE);
		register_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		register_1.setBackground(Color.BLUE);
		register_1.setBounds(8, 451, 123, 30);
		panel.add(register_1);

		JButton register = new JButton("離開程式");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String msg1 = "你是否要離開這個程式?";
				String msg2 = "離開程式";
				member = null;
				club = null;
				CommonUI.twoOption(msg1, msg2, () -> window.dispose());
				
			}
		});
		register.setForeground(Color.WHITE);
		register.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		register.setBackground(Color.BLUE);
		register.setBounds(8, 491, 123, 30);
		panel.add(register);
	}

	public static void userInfo(JPanel panel, Member member) {
		JLabel memberName_1 = new JLabel("未登入");
		memberName_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		memberName_1.setBounds(10, 10, 121, 30);
		panel.add(memberName_1);
		memberName_1.setText(member.getMemberName());

		JLabel memberId_1 = new JLabel("ID: XXXXXXX");
		memberId_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		memberId_1.setBounds(10, 39, 121, 30);
		panel.add(memberId_1);
		memberId_1.setText("ID:" + member.getMemberId());

	}
}
