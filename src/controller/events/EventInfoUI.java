package controller.events;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CommonUI;
import model.Clubs;
import model.EventClub;
import model.Events;
import model.Member;
import model.MemberState;
import service.Impl.EventClubServiceImpl;
import service.Impl.MemberStateServiceImpl;
import util.Common;
import util.Temp;

public class EventInfoUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	private Member member; // 儲存個人狀態用
	private Clubs club;
	private Events event;
	private MemberState memberstate;
	private EventClub eventClub;

	private String sqlPath = "dbInfo.txt";
	private String filePath = "member.txt";
	private String clubPath = "club.txt";
	private String filePathofMemberState = "memberState.txt";
	private String filePathofEventClub = "eventclub.txt";

	private String str;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventInfoUI frame = new EventInfoUI();
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
	public EventInfoUI() {
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

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(159, 69, 927, 554);
		panel.add(panel_1_1);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(9, 7, 908, 65);
		panel_1_1.add(panel_3_1);

		JLabel eventTitle = new JLabel("我的活動");
		eventTitle.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		eventTitle.setBounds(10, 10, 888, 42);
		panel_3_1.add(eventTitle);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1_1.setBounds(9, 82, 908, 462);
		panel_1_1.add(panel_2_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("活動時間");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(24, 113, 85, 40);
		panel_2_1_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("報名資格");
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(23, 151, 85, 40);
		panel_2_1_1.add(lblNewLabel_1_1_1_1_1);

		JLabel eventTime = new JLabel("未登入");
		eventTime.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		eventTime.setBounds(111, 113, 729, 40);
		panel_2_1_1.add(eventTime);

		JLabel clubUrl = new JLabel("社團團長可報名");
		clubUrl.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubUrl.setBounds(110, 151, 179, 40);
		panel_2_1_1.add(clubUrl);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("活動介紹");
		lblNewLabel_2_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(24, 188, 85, 40);
		panel_2_1_1.add(lblNewLabel_2_1_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(24, 227, 874, 165);
		panel_2_1_1.add(scrollPane);

		JTextArea eventDescription = new JTextArea();
		scrollPane.setViewportView(eventDescription);
		eventDescription.setText((String) null);
		eventDescription.setForeground(new Color(0, 0, 0));
		eventDescription.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		eventDescription.setEnabled(false);
		eventDescription.setLineWrap(true);  //自動換行
		eventDescription.setText(event.getEventDescription());

		// 報名按鈕顯示
		str = null;

		if (event.getEventIsPublish()) {
			str = "我要參加";

		} else {
			str = "活動未開放";
		}

		JButton addNewClub = new JButton(str);
		addNewClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (event.getEventIsPublish()) {
					// 1.判斷是否為團長
					// 檢查是否已經是其他社團的成員或團長
					boolean isClubLeader = new MemberStateServiceImpl().getUsetIsClubLeader(member);
					boolean isClubMember = new MemberStateServiceImpl().getUsetIsClubmember(member);

					// 查團員等級
					String memberLv = null;
					MemberState ms = new MemberStateServiceImpl().getClubByMember(memberstate.getMemberId());

					if (ms != null) {
						memberLv = ms.getLevel();
						System.out.println("1memberLv--" + memberLv);
					}
					// 查社團報名狀態
					
					EventClub ec1 = new EventClubServiceImpl().getRegisterStatus(event.getEventId(), memberstate.getClubId());
										
					// 2.是團長就可以報名

					if (isClubLeader || (memberLv != null && memberLv.equals("3"))) {

						if (ec1 != null) {

							JOptionPane.showMessageDialog(null, "已報名，不需重複報名。", "提示", JOptionPane.WARNING_MESSAGE);

						} else {

							EventClub ec = new EventClub(event.getEventId(), memberstate.getClubId(), true, null, null);
							new EventClubServiceImpl().joinEvents(ec);
							Temp.saveFile(filePathofEventClub, eventClub);
							JOptionPane.showMessageDialog(null, "報名完成。", "提示", JOptionPane.WARNING_MESSAGE);

						}

					} else {
						if (!isClubMember) {

							JOptionPane.showMessageDialog(null, "想參加活動，並須先加入任一社團喔。", "提示", JOptionPane.WARNING_MESSAGE);

						} else if (memberLv != null && !memberLv.equals("3")) {

							JOptionPane.showMessageDialog(null, "你的權限不足無法報名，請洽團長喔!!", "登入提示",
									JOptionPane.WARNING_MESSAGE);

						} else {

							JOptionPane.showMessageDialog(null, "這個目前活動無法報名。", "提示", JOptionPane.WARNING_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "這個目前活動無法報名。", "提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		addNewClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		addNewClub.setBackground(Color.GREEN);
		addNewClub.setBounds(502, 414, 193, 42);
		panel_2_1_1.add(addNewClub);

		JButton cancel = new JButton("返回");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EventListUI ui = new EventListUI();
				ui.setVisible(true);
				dispose();

			}
		});
		cancel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		cancel.setBackground(Color.GREEN);
		cancel.setBounds(705, 414, 193, 42);
		panel_2_1_1.add(cancel);

		// 視窗設定
		Common.setWindows(this);

		// ------畫面資訊----------------

		String bannerimg = event.getEventImg();

		JLabel img = new JLabel("New label");
		img.setIcon(new ImageIcon(EventInfoUI.class.getResource(bannerimg)));
		img.setBounds(0, 0, 908, 103);
		panel_2_1_1.add(img);

		eventTitle.setText(event.getEventTitle());
		eventTime.setText(event.getEventStartDate() + "至" + event.getEventEndDate());

	}
}
