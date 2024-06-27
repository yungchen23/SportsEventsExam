package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MessageBoardDao;
import model.MessageBoard;
import util.Common;
import util.DbConnection;

public class MessageBoardDaoImpl implements MessageBoardDao {

	public static void main(String[] args) {

		MessageBoardDaoImpl mbdi = new MessageBoardDaoImpl();

//		MessageBoard msg = new MessageBoard(null, "m000003", "c00001", "111XXXXXX,XXXXXXXXaaaanxxxxx1123axxxaaqqqqqqq", null,null);
//		new MessageBoardDaoImpl().addMsg(msg);
//
//		List<MessageBoard> m = mbdi.getMsgById(1);
//		System.out.println(m);
//		m.forEach((x) -> System.out.println(x.getId() + "-" + x.getMemberId() + "-" + x.getMessage()));
//
//		List<MessageBoard> m = mbdi.getMsgById(7);
//		System.out.println(m.size());
//		MessageBoard[] mb = m.toArray(new MessageBoard[m.size()]);
//		System.out.println(mb.length);
//		
//		mb[0].setMessage("aaaaaaaaaaa-vvvvvvvvvvvvvv-bbbbbbbbbbbbbbb-nnnnnnnnnnnnnn");
//		mbdi.updateMsg(mb[0]);
		
		mbdi.deletedMsg(7);
		
//		(String msgId, String memberId, String clubId, String message, String publishDate,
//		String updateDate) {		
	}

	@Override
	public void addMsg(MessageBoard msg) {

		Connection conn = DbConnection.getDb();
		String sql = "insert into messageboard(msgId,memberId,clubId,message,publishDate) values(?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Common.formatNumber("msg", new MessageBoardDaoImpl().getLatestId()));	
//			ps.setString(1, msg.getMsgId());
			ps.setString(2, msg.getMemberId());
			ps.setString(3, msg.getClubId());
			ps.setString(4, msg.getMessage());
			ps.setString(5, Common.creaditDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MessageBoard> getAllMsg() {

		List<MessageBoard> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from messageboard";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MessageBoard msg = new MessageBoard();
				msg.setId(rs.getInt("id"));
				msg.setMsgId(rs.getString("msgId"));
				msg.setMemberId(rs.getString("memberId"));
				msg.setClubId(rs.getString("clubId"));
				msg.setMessage(rs.getString("message"));
				msg.setPublishDate(rs.getString("publishDate"));
				msg.setUpdateDate(rs.getString("updateDate"));

				list.add(msg);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<MessageBoard> getMsgById(int id) {

		List<MessageBoard> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from messageboard where id =?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				MessageBoard msg = new MessageBoard();
				msg.setId(rs.getInt("id"));
				msg.setMsgId(rs.getString("msgId"));
				msg.setMemberId(rs.getString("memberId"));
				msg.setClubId(rs.getString("clubId"));
				msg.setMessage(rs.getString("message"));
				msg.setPublishDate(rs.getString("publishDate"));
				msg.setUpdateDate(rs.getString("updateDate"));

				list.add(msg);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public List<MessageBoard> getMsgByClub(String clubId) {
		List<MessageBoard> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from messageboard where clubId =?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, clubId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MessageBoard msg = new MessageBoard();
				msg.setId(rs.getInt("id"));
				msg.setMsgId(rs.getString("msgId"));
				msg.setMemberId(rs.getString("memberId"));
				msg.setClubId(rs.getString("clubId"));
				msg.setMessage(rs.getString("message"));
				msg.setPublishDate(rs.getString("publishDate"));
				msg.setUpdateDate(rs.getString("updateDate"));

				list.add(msg);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public Integer getLatestId() { // 取得最新一筆id

		Integer len = null;

		List<MessageBoard> list = getAllMsg();
		MessageBoard[] mb = list.toArray(new MessageBoard[list.size()]);

		if ((mb.length - 1) >= 0) {
			len = mb[mb.length - 1].getId();
		} else {
			len = 0;
		}
		return len;
	}


	@Override
	public void updateMsg(MessageBoard msg) {
		Connection conn = DbConnection.getDb();
		String sql = "update messageboard set message=?,updateDate=? where id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, msg.getMessage());
			ps.setString(2, Common.updateDate());
			ps.setInt(3, msg.getId());
			
			ps.executeUpdate();

			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}


	@Override
	public void deletedMsg(int id) {
		Connection conn = DbConnection.getDb();
		String sql ="delete from messageboard where id=?";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
