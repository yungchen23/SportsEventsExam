package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EventClubDao;
import model.EventClub;
import util.Common;
import util.DbConnection;

public class EventClubDaoImpl implements EventClubDao{

	public static void main(String[] args) {
	
	
	}

	
	@Override
	public void joinEvents(EventClub ec) {

		Connection conn = DbConnection.getDb();
		String sql = "insert into eventclub(eventId,clubId,joinStatus,joinDate) values(?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ec.getEventId());
			ps.setString(2, ec.getClubId());
//			ps.setBoolean(3, ec.getJoinStatus());
			ps.setBoolean(3, true);  //預設為true
			ps.setString(4, Common.joinDate());

			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}

	@Override
	public List<EventClub> getAllClubs() {
		List<EventClub> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from eventclub";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
				EventClub ec = new EventClub();
				ec.setId(rs.getInt("id"));
				ec.setEventId(rs.getString("eventId"));
				ec.setClubId(rs.getString("clubId"));
				ec.setJoinStatus(rs.getBoolean("joinStatus"));
				ec.setJoinDate(rs.getString("joinDate"));
				ec.setUpdateDate(rs.getString("updateDate"));			
				list.add(ec);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<EventClub> getClubsById(int id) {
		List<EventClub> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from eventclub where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
	
			if(rs.next()) {
				EventClub ec = new EventClub();
				ec.setId(rs.getInt("id"));
				ec.setEventId(rs.getString("eventId"));
				ec.setClubId(rs.getString("clubId"));
				ec.setJoinStatus(rs.getBoolean("joinStatus"));
				ec.setJoinDate(rs.getString("joinDate"));
				ec.setUpdateDate(rs.getString("updateDate"));			
				list.add(ec);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<EventClub> getRegisterStatus(String eventId, String clubId) {
		List<EventClub> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from eventclub where eventId=? and clubId=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, eventId);
			ps.setString(2, clubId);			
			ResultSet rs = ps.executeQuery();
	
			if(rs.next()) {
				EventClub ec = new EventClub();
				ec.setId(rs.getInt("id"));
				ec.setEventId(rs.getString("eventId"));
				ec.setClubId(rs.getString("clubId"));
				ec.setJoinStatus(rs.getBoolean("joinStatus"));
				ec.setJoinDate(rs.getString("joinDate"));
				ec.setUpdateDate(rs.getString("updateDate"));			
				list.add(ec);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	@Override
	public void updateRegister(EventClub ec) {
		Connection conn = DbConnection.getDb();
		String sql = "update eventclub set joinStatus=?,updateDate=? where id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, ec.getJoinStatus());
			ps.setString(2, Common.updateDate());
			ps.setInt(3, ec.getId());
			
			ps.executeUpdate();

			
		} catch (SQLException e) {

			e.printStackTrace();
		}	
	}



}
