package controller.clubs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CommonUI;
import model.Clubs;
import model.Member;
import model.MemberState;
import model.views.getclubofmember;
import service.Impl.ClubsServiceImpl;
import service.Impl.GetclubofmemberServiceImpl;
import util.Common;
import util.Temp;

public class ClubsEdit2UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField clubUrl;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubsEdit2UI frame = new ClubsEdit2UI();
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
	public ClubsEdit2UI() {
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

		// 建立邊框
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);

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

		JLabel lblNewLabel_3 = new JLabel("社團編輯");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 132, 42);
		panel_3_1.add(lblNewLabel_3);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1_1.setBounds(9, 82, 908, 462);
		panel_1_1.add(panel_2_1_1);

		JLabel lblNewLabel_4 = new JLabel("社團名稱");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(24, 10, 85, 40);
		panel_2_1_1.add(lblNewLabel_4);

		JLabel lblNewLabel_2_2 = new JLabel("團長");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(24, 113, 85, 40);
		panel_2_1_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_1 = new JLabel("創建時間");
		lblNewLabel_2_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(24, 163, 85, 40);
		panel_2_1_1.add(lblNewLabel_2_1_1);

		JLabel clubName = new JLabel((String) null);
		clubName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubName.setBounds(108, 10, 465, 40);
		panel_2_1_1.add(clubName);
		clubName.setBorder(border);

		JLabel creditDate = new JLabel("未登入");
		creditDate.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		creditDate.setBounds(109, 163, 464, 40);
		panel_2_1_1.add(creditDate);
		creditDate.setBorder(border);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("網址");
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(24, 213, 85, 40);
		panel_2_1_1.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_4_1 = new JLabel("ID");
		lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(24, 63, 85, 40);
		panel_2_1_1.add(lblNewLabel_4_1);

		JLabel clubID = new JLabel((String) null);
		clubID.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubID.setBounds(108, 63, 465, 40);
		panel_2_1_1.add(clubID);
		clubID.setBorder(border);

		JLabel LeaderName = new JLabel("未登入");
		LeaderName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		LeaderName.setBounds(111, 113, 462, 40);
		panel_2_1_1.add(LeaderName);
		LeaderName.setBorder(border);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("社團公告");
		lblNewLabel_2_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(24, 266, 85, 40);
		panel_2_1_1.add(lblNewLabel_2_1_1_1);

		clubUrl = new JTextField();
		clubUrl.setText((String) null);
		clubUrl.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubUrl.setColumns(10);
		clubUrl.setBounds(108, 213, 465, 40);
		panel_2_1_1.add(clubUrl);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(108, 277, 465, 160);
		panel_2_1_1.add(scrollPane);

		JTextArea clubBillboard = new JTextArea();
		scrollPane.setViewportView(clubBillboard);
		clubBillboard.setText((String) null);
		clubBillboard.setForeground(new Color(64, 0, 64));
		clubBillboard.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

		JButton clubSava = new JButton("儲存");
		clubSava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//判斷網址格式
				String url = clubUrl.getText();
				
				if(!url.contains("https://")||!url.contains("http://") ) {
					
					url = "https://"+url;
				}

				try {
					System.out.println("club.getClubId()=="+club.getClubId());
					
					club.setClubBillboard(clubBillboard.getText());
					club.setClubUrl(url);
					
					new ClubsServiceImpl().updateClubs(club);
					
					if(club!=null) {
						JOptionPane.showMessageDialog(null, "儲存完成", "提示", JOptionPane.WARNING_MESSAGE);
					}
					Temp.saveFile(clubPath, club);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "儲存失敗", "提示", JOptionPane.WARNING_MESSAGE);
					e2.printStackTrace();
				}
			}
		});
		clubSava.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubSava.setBackground(Color.GREEN);
		clubSava.setBounds(705, 396, 193, 42);
		panel_2_1_1.add(clubSava);

		// 視窗設定
		Common.setWindows(this);

		// =============畫面載入後預設顯示數據==================
		
		getclubofmember gcf =new GetclubofmemberServiceImpl().getLeaderbyClub(club.getClubId());  //獲得團長名稱用
		
		clubName.setText(club.getClubName());
		clubID.setText(club.getClubId());
		LeaderName.setText(gcf.getMAMBERNAME());
		clubUrl.setText(club.getClubUrl());
		creditDate.setText(club.getCreateDate());
		clubBillboard.setText(club.getClubBillboard());

	}
}
