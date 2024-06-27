package controller.events;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CommonUI;
import model.Clubs;
import model.EventClub;
import model.Events;
import model.Member;
import model.MemberState;
import service.Impl.EventClubServiceImpl;
import service.Impl.EventsSerivceImpl;
import util.Common;
import util.Temp;

public class EventUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	
	//儲存狀態用
	private Member member; 
	private Clubs club;
	private MemberState memberstate;
	private Events event;
	private EventClub eventClub;
	
	//儲存路徑
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
					EventUI frame = new EventUI();
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
	public EventUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 1086, 633);
		contentPane.add(panel);
		panel.setLayout(null);

		// -----首次登入先捕捉下來的檔案----------------------------------------------------------
		
		CommonUI.CookieData();

		memberstate = CommonUI.memberstate;
		member = CommonUI.member;
		club = CommonUI.club;
		event = CommonUI.event;
		eventClub = CommonUI.eventClub;
		
		

		// -----上方選單----------------------------------------------------------

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 1086, 68);
		panel.add(panel_3);

		CommonUI.TopMenu(panel_3, this);

		// -----側邊選單(Events)----------------------------------------------------

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 69, 139, 554);
		panel.add(panel_1);

		JPanel side_panel_1 = new JPanel();
		side_panel_1.setLayout(null);
		side_panel_1.setBounds(0, 0, 139, 554);
		panel_1.add(side_panel_1);

		CommonUI.SideMenuEvent(side_panel_1, this);

		// --登出離開------------------------

		CommonUI.exitMenu(side_panel_1, this);

		// --登入資訊--------------

		CommonUI.userInfo(side_panel_1, member);

		// ---------表格內數據----------------------
		
//		//撈出所有活動數據，作為首頁banner用途		
//		List<EventClub>list = new EventClubServiceImpl().getAllClubs();
		


		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(159, 69, 927, 554);
		panel.add(panel_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(9, 7, 908, 65);
		panel_1_1.add(panel_3_1);


		
		JLabel lblNewLabel_3 = new JLabel("熱門活動");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 132, 42);
		panel_3_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel(">更多活動");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				EventListUI ui = new EventListUI();
				ui.setVisible(true);
				dispose();
				
			}
		});
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel.setBounds(797, 32, 101, 23);
		panel_3_1.add(lblNewLabel);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1.setBounds(10, 84, 907, 460);
		panel_1_1.add(panel_2_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 907, 460);
		panel_2_1.add(panel_2);
		
		
		JLabel banner1 = new JLabel("New label");
		banner1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				Events event1 = new EventsSerivceImpl().getEventsById(2);
				Temp.saveFile(filePathofEvent, event1);
				
				EventInfoUI ui = new EventInfoUI();
				ui.setVisible(true);
				dispose();

			}
		});		
		banner1.setIcon(new ImageIcon(EventUI.class.getResource("/controller/img/banner_003.png")));
		banner1.setBounds(10, 10, 868, 106);
		panel_2.add(banner1);
		
		JLabel banner2 = new JLabel("New label");
		banner2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Events event1 = new EventsSerivceImpl().getEventsById(3);
				Temp.saveFile(filePathofEvent, event1);
				
				EventInfoUI ui = new EventInfoUI();
				ui.setVisible(true);
				dispose();

			}
		});
		banner2.setIcon(new ImageIcon(EventUI.class.getResource("/controller/img/banner_002.png")));
		banner2.setBounds(10, 140, 868, 106);
		panel_2.add(banner2);
		
		JLabel banner3 = new JLabel("New label");
		banner3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Events event1 = new EventsSerivceImpl().getEventsById(5);
				Temp.saveFile(filePathofEvent, event1);
				
				EventInfoUI ui = new EventInfoUI();
				ui.setVisible(true);
				dispose();
				
			}
		});
		banner3.setIcon(new ImageIcon(EventUI.class.getResource("/controller/img/banner_001.png")));
		banner3.setBounds(10, 273, 868, 106);
		panel_2.add(banner3);

		// 視窗設定
		Common.setWindows(this);

	}
}
