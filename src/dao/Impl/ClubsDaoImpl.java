package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClubsDao;
import model.Clubs;
import util.Common;
import util.DbConnection;

public class ClubsDaoImpl implements ClubsDao {

	public static void main(String[] args) {

	}

	@Override
	public void addClubs(Clubs c) {

		Connection conn = DbConnection.getDb();
		String sql = "insert into clubs(clubId,clubName,clubLeaderId,clubIntroduction,clubBillboard,clubUrl,createDate) values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Common.formatNumber("c", new ClubsDaoImpl().getLatestId()));
			ps.setString(2, c.getClubName());
			ps.setString(3, c.getClubLeaderId());
			ps.setString(4, c.getClubIntroduction());
			ps.setString(5, c.getClubBillboard());
			ps.setString(6, c.getClubUrl());
			ps.setString(7, Common.creaditDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Clubs> getAllClubs() {
		List<Clubs> list = new ArrayList<Clubs>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from clubs";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Clubs c = new Clubs();
				c.setId(rs.getInt("id"));
				c.setClubId(rs.getString("clubId"));
				c.setClubName(rs.getString("clubName"));
				c.setClubLeaderId(rs.getString("clubLeaderId"));
				c.setClubIntroduction(rs.getString("clubIntroduction"));
				c.setClubBillboard(rs.getString("clubBillboard"));
				c.setClubUrl(rs.getString("clubUrl"));
				c.setCreateDate(rs.getString("createDate"));
				c.setUpdateDate(rs.getString("updateDate"));

				list.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Clubs> getClubsById(int id) {
		List<Clubs> list = new ArrayList<Clubs>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from clubs where id =?";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Clubs c = new Clubs();
				c.setId(rs.getInt("id"));
				c.setClubId(rs.getString("clubId"));
				c.setClubName(rs.getString("clubName"));
				c.setClubLeaderId(rs.getString("clubLeaderId"));
				c.setClubIntroduction(rs.getString("clubIntroduction"));
				c.setClubBillboard(rs.getString("clubBillboard"));
				c.setClubUrl(rs.getString("clubUrl"));
				c.setCreateDate(rs.getString("createDate"));

				list.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Clubs> getClubsByClubId(String ClubId) {
		List<Clubs> list = new ArrayList<Clubs>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from clubs where ClubId =?";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ClubId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Clubs c = new Clubs();
				c.setId(rs.getInt("id"));
				c.setClubId(rs.getString("clubId"));
				c.setClubName(rs.getString("clubName"));
				c.setClubLeaderId(rs.getString("clubLeaderId"));
				c.setClubIntroduction(rs.getString("clubIntroduction"));
				c.setClubBillboard(rs.getString("clubBillboard"));
				c.setClubUrl(rs.getString("clubUrl"));
				c.setCreateDate(rs.getString("createDate"));

				list.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateClubs(Clubs c) {

		Connection conn = DbConnection.getDb();
		String sql = "update clubs set clubBillboard=?,clubUrl =?,updateDate=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getClubBillboard());
			ps.setString(2, c.getClubUrl());
			ps.setString(3, Common.updateDate());
			ps.setInt(4, c.getId());

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void updateClubsName(Clubs c) {
		Connection conn = DbConnection.getDb();
		String sql = "update clubs set clubName=?,updateDate=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getClubName());
			ps.setString(2, Common.updateDate());
			ps.setInt(3, c.getId());

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void deletedClubs(int id) {
		Connection conn = DbConnection.getDb();
		String sql = "delete from clubs where id=?";

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

	@Override
	public Integer getLatestId() { // 取得最新一筆id

		Integer len = null;

		List<Clubs> list = getAllClubs();
		Clubs[] c = list.toArray(new Clubs[list.size()]);

		if ((c.length - 1) >= 0) {
			len = c[c.length - 1].getId();
		} else {
			len = 0;
		}
		return len;
	}

}
