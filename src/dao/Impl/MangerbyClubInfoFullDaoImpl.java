package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MangerbyClubInfoFullDao;
import model.views.mangerbyclubinfoFull;
import util.DbConnection;

public class MangerbyClubInfoFullDaoImpl implements MangerbyClubInfoFullDao{

	@Override
	public List<mangerbyclubinfoFull> getAllMember() {
		List<mangerbyclubinfoFull> list = new ArrayList<>();
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM mangerbyclubinfofull";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mangerbyclubinfoFull mbf = new mangerbyclubinfoFull();
				mbf.setMid(rs.getString("Mid"));
				mbf.setName(rs.getString("name"));
				mbf.setAccount(rs.getString("account"));
				mbf.setGender(rs.getString("gender"));
				mbf.setAge(rs.getString("age"));
				mbf.setBirthday(rs.getString("birthday"));
				mbf.setEmail(rs.getString("Email"));
				mbf.setPhone(rs.getString("phone"));
				mbf.setLocation(rs.getString("location"));
				mbf.setJoinclub(rs.getString("joinclub"));
				mbf.setStatus(rs.getString("status"));				
				mbf.setCreateDate(rs.getString("createDate"));

				list.add(mbf);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<mangerbyclubinfoFull> getMemberbyClub(String joinclub) {
		List<mangerbyclubinfoFull> list = new ArrayList<>();
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM mangerbyclubinfofull where joinclub =?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, joinclub);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mangerbyclubinfoFull mbf = new mangerbyclubinfoFull();
				mbf.setMid(rs.getString("Mid"));
				mbf.setName(rs.getString("name"));
				mbf.setAccount(rs.getString("account"));
				mbf.setGender(rs.getString("gender"));
				mbf.setAge(rs.getString("age"));
				mbf.setBirthday(rs.getString("birthday"));
				mbf.setEmail(rs.getString("Email"));
				mbf.setPhone(rs.getString("phone"));
				mbf.setLocation(rs.getString("location"));
				mbf.setJoinclub(rs.getString("joinclub"));
				mbf.setStatus(rs.getString("status"));				
				mbf.setCreateDate(rs.getString("createDate"));

				list.add(mbf);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
