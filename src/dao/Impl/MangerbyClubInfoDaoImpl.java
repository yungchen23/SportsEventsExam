package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MangerbyClubInfoDao;
import model.views.mangerbyclubinfo;
import util.DbConnection;

public class MangerbyClubInfoDaoImpl implements MangerbyClubInfoDao {

	public static void main(String[] args) {
		List<mangerbyclubinfo> l= new MangerbyClubInfoDaoImpl().getMemberbyClub("c00002");
		l.forEach((x->System.out.println(x.getClubId()+"-"+x.getClubName())));
	}

	@Override
	public List<mangerbyclubinfo> getAllMember() {

		List<mangerbyclubinfo> list = new ArrayList<>();
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM mangerbyclubinfo";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mangerbyclubinfo mbc = new mangerbyclubinfo();
				mbc.setClubId(rs.getString("ID"));
				mbc.setClubName(rs.getString("clubName"));
				mbc.setClubLeader(rs.getString("clubLeader"));
				mbc.setClubIntroduction(rs.getString("clubIntroduction"));
				mbc.setNumberofMembers(rs.getInt("NumberofMembers"));
				mbc.setCreateDate(rs.getString("createDate"));

				list.add(mbc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<mangerbyclubinfo> getMemberbyClub(String clubId) {

		List<mangerbyclubinfo> list = new ArrayList<>();
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM mangerbyclubinfo where id= ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, clubId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mangerbyclubinfo mbc = new mangerbyclubinfo();
				mbc.setClubId(rs.getString("ID"));
				mbc.setClubName(rs.getString("clubName"));
				mbc.setClubLeader(rs.getString("clubLeader"));
				mbc.setClubIntroduction(rs.getString("clubIntroduction"));
				mbc.setNumberofMembers(rs.getInt("NumberofMembers"));
				mbc.setCreateDate(rs.getString("createDate"));

				list.add(mbc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
