package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.NoticeMemberDao;
import model.NoticeMember;
import util.Common;
import util.DbConnection;

public class NoticeMemberDaoImpl implements NoticeMemberDao{

	public static void main(String[] args) {
		

	}

	@Override
	public void addMsg(NoticeMember notice) {
		Connection conn = DbConnection.getDb();
		String sql = "insert into noticemember(noticeId,memberId,clubId,topic,message,publishDate) values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Common.formatNumber("nt", new NoticeMemberDaoImpl().getLatestId()));	
//			ps.setString(1, msg.getMsgId());
			ps.setString(2, notice.getMemberId());
			ps.setString(3, notice.getClubId());
			ps.setString(4, notice.getTopic());			
			ps.setString(5, notice.getMessage());
			ps.setString(6, Common.creaditDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<NoticeMember> getAllNotice() {

		List<NoticeMember> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from noticemember";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				NoticeMember notice = new NoticeMember();
				notice.setId(rs.getInt("id"));
				notice.setNoticeId(rs.getString("noticeId"));
				notice.setMemberId(rs.getString("memberId"));
				notice.setClubId(rs.getString("clubId"));
				notice.setTopic(rs.getString("topic"));
				notice.setMessage(rs.getString("message"));
				notice.setPublishDate(rs.getString("publishDate"));

				list.add(notice);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<NoticeMember> getNoticeById(int id) {
		List<NoticeMember> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from noticemember where id =?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				NoticeMember notice = new NoticeMember();
				notice.setId(rs.getInt("id"));
				notice.setNoticeId(rs.getString("noticeId"));
				notice.setMemberId(rs.getString("memberId"));
				notice.setClubId(rs.getString("clubId"));
				notice.setTopic(rs.getString("topic"));
				notice.setMessage(rs.getString("message"));
				notice.setPublishDate(rs.getString("publishDate"));

				list.add(notice);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<NoticeMember> getNoticeByMember(String memberId) {
		List<NoticeMember> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from noticemember where memberId =?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				NoticeMember notice = new NoticeMember();
				notice.setId(rs.getInt("id"));
				notice.setNoticeId(rs.getString("noticeId"));
				notice.setMemberId(rs.getString("memberId"));
				notice.setClubId(rs.getString("clubId"));
				notice.setTopic(rs.getString("topic"));
				notice.setMessage(rs.getString("message"));
				notice.setPublishDate(rs.getString("publishDate"));

				list.add(notice);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<NoticeMember> getNoticeByClub(String clubId) {
		List<NoticeMember> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from noticemember where clubId =?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, clubId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				NoticeMember notice = new NoticeMember();
				notice.setId(rs.getInt("id"));
				notice.setNoticeId(rs.getString("noticeId"));
				notice.setMemberId(rs.getString("memberId"));
				notice.setClubId(rs.getString("clubId"));
				notice.setTopic(rs.getString("topic"));
				notice.setMessage(rs.getString("message"));
				notice.setPublishDate(rs.getString("publishDate"));

				list.add(notice);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public Integer getLatestId() {
		Integer len = null;

		List<NoticeMember> list = getAllNotice();
		NoticeMember[] nm = list.toArray(new NoticeMember[list.size()]);

		if ((nm.length - 1) >= 0) {
			len = nm[nm.length - 1].getId();
		} else {
			len = 0;
		}
		return len;
	}

	@Override
	public void deletedNotice(int id) {
		Connection conn = DbConnection.getDb();
		String sql ="delete from noticemember where id=?";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
