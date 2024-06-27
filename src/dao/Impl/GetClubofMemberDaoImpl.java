package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GetClubofMemberDao;
import model.views.getclubofmember;
import util.DbConnection;

public class GetClubofMemberDaoImpl implements GetClubofMemberDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<getclubofmember> getAllMember() {
		List<getclubofmember> list = new ArrayList<>();
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM getclubofmember";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				getclubofmember mbc = new getclubofmember();
				mbc.setCLUBID(rs.getString("CLUBID"));
				mbc.setCLUBNAME(rs.getString("CLUBNAME"));
				mbc.setMAMBERNAME(rs.getString("MAMBERNAME"));
				mbc.setTITLE(rs.getString("TITLE"));
				mbc.setLEVEL(rs.getString("LEVEL"));
				mbc.setJOINTIME(rs.getString("JOINTIME"));
				mbc.setUPDATETIME(rs.getString("UPDATETIME"));
				
				list.add(mbc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<getclubofmember> getMemberbyClub(String clubId) {
		List<getclubofmember> list = new ArrayList<>();
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM getclubofmember where CLUBID= ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, clubId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				getclubofmember mbc = new getclubofmember();
				mbc.setCLUBID(rs.getString("CLUBID"));
				mbc.setCLUBNAME(rs.getString("CLUBNAME"));
				mbc.setMAMBERNAME(rs.getString("MAMBERNAME"));
				mbc.setTITLE(rs.getString("TITLE"));
				mbc.setLEVEL(rs.getString("LEVEL"));
				mbc.setJOINTIME(rs.getString("JOINTIME"));
				mbc.setUPDATETIME(rs.getString("UPDATETIME"));

				list.add(mbc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public getclubofmember getLeaderbyClub(String clubId) {
		
		getclubofmember mbc =null;
		
		List<getclubofmember> list = new ArrayList<>();
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM getclubofmember where CLUBID= ? and TITLE=? ";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, clubId);
			ps.setString(2, "團長");
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				mbc = new getclubofmember();
				mbc.setCLUBID(rs.getString("CLUBID"));
				mbc.setCLUBNAME(rs.getString("CLUBNAME"));
				mbc.setMAMBERNAME(rs.getString("MAMBERNAME"));
				mbc.setTITLE(rs.getString("TITLE"));
				mbc.setLEVEL(rs.getString("LEVEL"));
				mbc.setJOINTIME(rs.getString("JOINTIME"));
				mbc.setUPDATETIME(rs.getString("UPDATETIME"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mbc;
	}

	


	
}
