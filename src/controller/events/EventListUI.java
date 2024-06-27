package controller.events;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableColumn;

import controller.CommonUI;
import controller.model.EventListTableModel;
import model.Clubs;
import model.Events;
import model.Member;
import model.MemberState;
import service.Impl.EventsSerivceImpl;
import util.Common;
import util.Temp;

public class EventListUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private Member member; // 儲存個人狀態用
	private Clubs club;
	private MemberState memberstate;
	private Events event;
	private String sqlPath = "dbInfo.txt";
	private String filePath = "member.txt";
	private String clubPath = "club.txt";
	private String filePathofMemberState = "memberState.txt";
	private String filePathofEvent = "events.txt";
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventListUI frame = new EventListUI();
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
	public EventListUI() {
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
		List<Events> list = new EventsSerivceImpl().getEventsByPublish(true);
		EventListTableModel model = new EventListTableModel(list);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(159, 69, 927, 554);
		panel.add(panel_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(9, 7, 908, 65);
		panel_1_1.add(panel_3_1);

		JLabel lblNewLabel_3 = new JLabel("活動清單");
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

		JLabel lblNewLabel_1 = new JLabel("※連續點擊2下任一個活動，可查看詳情");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 10, 553, 29);
		panel_2.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 49, 866, 369);
		panel_2.add(scrollPane);

		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) { // 雙擊才會觸發加入社團

					JTable target = (JTable) e.getSource();
					int row = target.getSelectedRow(); // 獲取選中的行

					//把選取到的資料撈出來，並存起來
					// 1.獲取選中行的社團ID
					String eventId = table.getModel().getValueAt(row, 0).toString(); // 捕捉社團id是第一列時的數據
					Integer eid = Integer.parseInt(eventId);
										
					Events event1 = new EventsSerivceImpl().getEventsById(eid);
					Temp.saveFile(filePathofEvent, event1);
					
					
					System.out.println("我到底改壞了哪裡~~~~~~~~~"+eventId);
//					System.out.println(list);
					System.out.println(event1.getEventTitle());
					EventInfoUI ui = new EventInfoUI();
					ui.setVisible(true);
					dispose();

				}
			}
		});

		table.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		scrollPane.setViewportView(table);

		// 視窗設定
		Common.setWindows(this);

		// 設置table表格欄位寬度
		setColumnWidths(table);

	}

	private void setColumnWidths(JTable table) {
		TableColumn column;
		for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			switch (i) {
			case 0:
				column.setPreferredWidth(15);
				break;
			case 1:
				column.setPreferredWidth(150);
				break;
			case 2:
				column.setPreferredWidth(150);
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
