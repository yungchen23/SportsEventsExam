package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MyMsglistDao;
import model.views.myMsglist;
import util.DbConnection;

public class MyMsglistDaoImpl implements MyMsglistDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<myMsglist> getAllMsg() {
		
		List<myMsglist> list = new ArrayList<>();
		
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM mymsglist";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				myMsglist no = new myMsglist();
				no.setID(rs.getInt("ID"));
				no.setMemberId(rs.getString("memberId"));
				no.setMemberName(rs.getString("memberName"));
				no.setClubId(rs.getString("clubId"));
				no.setMessage(rs.getString("message"));				
				no.setPublishDate(rs.getString("publishDate"));
				
				list.add(no);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<myMsglist> getMsgbyClubs(String clubId) {
		
		List<myMsglist> list = new ArrayList<>();
		
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM mymsglist where clubId=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, clubId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				myMsglist no = new myMsglist();
				no.setID(rs.getInt("ID"));
				no.setMemberId(rs.getString("memberId"));
				no.setMemberName(rs.getString("memberName"));
				no.setClubId(rs.getString("clubId"));
				no.setMessage(rs.getString("message"));				
				no.setPublishDate(rs.getString("publishDate"));
				
				list.add(no);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
}
