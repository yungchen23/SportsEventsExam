package controller.clubs;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CommonUI;
import controller.model.MyClubMemberList2TableModel;
import model.Clubs;
import model.Member;
import model.MemberState;
import model.views.getclubofmember;
import model.views.mangerbyclubinfoFull;
import service.Impl.GetclubofmemberServiceImpl;
import service.Impl.MangerbyClubInfoFullServiceImpl;
import util.Common;

public class MyClubsUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;
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
					MyClubsUI frame = new MyClubsUI();
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
	public MyClubsUI() {
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

		List<mangerbyclubinfoFull> list = new MangerbyClubInfoFullServiceImpl().getMemberbyClub(club.getClubName());
		MyClubMemberList2TableModel model = new MyClubMemberList2TableModel(list);
		

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

		// --建立邊框--------------
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(159, 69, 927, 554);
		panel.add(panel_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(9, 7, 908, 65);
		panel_1_1.add(panel_3_1);

		JLabel lblNewLabel_3 = new JLabel("我的社團");
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
		lblNewLabel_2_1_1.setBounds(24, 216, 85, 40);
		panel_2_1_1.add(lblNewLabel_2_1_1);

		JLabel clubName = new JLabel((String) null);
		clubName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubName.setBounds(110, 10, 281, 40);
		panel_2_1_1.add(clubName);
		clubName.setBorder(border);

		JLabel creditDate = new JLabel("未登入");
		creditDate.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		creditDate.setBounds(110, 216, 281, 40);
		panel_2_1_1.add(creditDate);
		creditDate.setBorder(border);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("網址");
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(24, 163, 85, 40);
		panel_2_1_1.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_4_1 = new JLabel("ID");
		lblNewLabel_4_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(24, 63, 85, 40);
		panel_2_1_1.add(lblNewLabel_4_1);

		JLabel clubID = new JLabel((String) null);
		clubID.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubID.setBounds(110, 63, 281, 40);
		panel_2_1_1.add(clubID);
		clubID.setBorder(border);

		JLabel LeaderName = new JLabel("未登入");
		LeaderName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		LeaderName.setBounds(110, 113, 281, 40);
		panel_2_1_1.add(LeaderName);
		LeaderName.setBorder(border);

		JLabel clubUrl = new JLabel("未登入");
		clubUrl.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubUrl.setBounds(110, 163, 235, 40);
		panel_2_1_1.add(clubUrl);
		clubUrl.setBorder(border);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("社團公告");
		lblNewLabel_2_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(446, 10, 85, 40);
		panel_2_1_1.add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("社團成員");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(23, 279, 86, 15);
		panel_2_1_1.add(lblNewLabel_1_2);

		JButton printerBTN = new JButton("列印通訊錄");
		printerBTN.setForeground(Color.WHITE);
		printerBTN.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		printerBTN.setBackground(new Color(64, 0, 64));
		printerBTN.setBounds(775, 262, 123, 32);
		panel_2_1_1.add(printerBTN);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 304, 874, 148);
		panel_2_1_1.add(scrollPane_1);

		table = new JTable(model);
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table);

		// 視窗設定
		Common.setWindows(this);

		// =============畫面載入後預設顯示數據==================
		
		
		getclubofmember gcf =new GetclubofmemberServiceImpl().getLeaderbyClub(club.getClubId());  //獲得團長名稱用
		
		clubName.setText(club.getClubName());
		clubID.setText(club.getClubId());
		LeaderName.setText(gcf.getMAMBERNAME());
		clubUrl.setText(club.getClubUrl());
		creditDate.setText(club.getCreateDate());
		
		JButton btnNewButton = new JButton(".....");		
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 指定開啟的URL
                String url = club.getClubUrl();

                // 呼叫openWebpage方法開啟RUL
                openWebpage(url);
            }
        });
		btnNewButton.setBounds(350, 171, 41, 32);
		panel_2_1_1.add(btnNewButton);
		
				JTextArea clubBillboard = new JTextArea();
				clubBillboard.setBounds(446, 59, 424, 112);
				panel_2_1_1.add(clubBillboard);
				clubBillboard.setText((String) null);
				clubBillboard.setForeground(new Color(64, 0, 64));
				clubBillboard.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
				clubBillboard.setEnabled(false);
				clubBillboard.setText(club.getClubBillboard());

	}
	
	  // 網路找來的打開Web page方法
    public static void openWebpage(String urlString) {
        try {
            URI uri = new URI(urlString);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("Desktop is not supported");
                JOptionPane.showMessageDialog(null, "網址錯誤無法開啟", "登入提示", JOptionPane.WARNING_MESSAGE);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
