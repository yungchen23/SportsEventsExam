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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.CommonUI;
import model.Clubs;
import model.Member;
import model.MemberState;
import model.MessageBoard;
import service.Impl.MessageBoardServiceImpl;
import util.Common;

public class ClubsPostMsgUI extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubsPostMsgUI frame = new ClubsPostMsgUI();
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
	public ClubsPostMsgUI() {
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

		// --建立邊框--------------
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
		
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

		JLabel lblNewLabel_3 = new JLabel("我要留言");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 10, 132, 42);
		panel_3_1.add(lblNewLabel_3);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2_1_1.setBounds(9, 83, 908, 449);
		panel_1_1.add(panel_2_1_1);

		JLabel lblNewLabel_1 = new JLabel("留言內容");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 96, 86, 15);
		panel_2_1_1.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 94, 588, 274);
		panel_2_1_1.add(scrollPane);

		JTextArea clubMsg = new JTextArea();
		scrollPane.setViewportView(clubMsg);
		clubMsg.setFont(new Font("微軟正黑體", Font.PLAIN, 16));

		JLabel clubName = new JLabel((String) null);
		clubName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		clubName.setBounds(107, 25, 588, 40);
		panel_2_1_1.add(clubName);
		clubName.setBorder(border);

		JLabel lblNewLabel_4 = new JLabel("社團名稱");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(20, 25, 85, 40);
		panel_2_1_1.add(lblNewLabel_4);

		JButton addNewClub = new JButton("發表留言");
		addNewClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String msg = clubMsg.getText();

				if (msg.isEmpty()) {

					JOptionPane.showMessageDialog(null, "路過也請留下一點東西!!", "提示", JOptionPane.WARNING_MESSAGE);

				} else {

					MessageBoard msg2 = new MessageBoard(null, member.getMemberId(), club.getClubId(), msg, null, null);
					new MessageBoardServiceImpl().addMsg(msg2);

					clubMsg.setText("");
					JOptionPane.showMessageDialog(null, "留言成功", "提示", JOptionPane.WARNING_MESSAGE);
					
					ClubsMsgBoardUI ui = new ClubsMsgBoardUI();
					ui.setVisible(true);
					dispose();
					
				}

			}
		});
		addNewClub.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		addNewClub.setBackground(Color.GREEN);
		addNewClub.setBounds(502, 397, 193, 42);
		panel_2_1_1.add(addNewClub);

		JButton cancel = new JButton("返回上頁");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				clubMsg.setText("");
				ClubsMsgBoardUI ui = new ClubsMsgBoardUI();
				ui.setVisible(true);
				dispose();

			}
		});
		cancel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		cancel.setBackground(Color.GREEN);
		cancel.setBounds(705, 397, 193, 42);
		panel_2_1_1.add(cancel);

		// 視窗設定
		Common.setWindows(this);

		// =============畫面載入後預設顯示數據==================
		clubName.setText(club.getClubName());

	}
}
