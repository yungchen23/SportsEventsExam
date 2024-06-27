package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EventsDao;
import model.Events;
import util.Common;
import util.DbConnection;

public class EventsDaoImpl implements EventsDao {

	public static void main(String[] args) {

	}

	@Override
	public void addEvents(Events e) {

		Connection conn = DbConnection.getDb();
		String sql = "insert into events(eventId,eventTitle,eventDescription,eventStartDate,eventEndDate,eventIsPublish,createDate,eventImg) values(?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Common.formatNumber("e", new EventsDaoImpl().getLatestId()));
			System.out.println("x==>" + new EventsDaoImpl().getLatestId());
			ps.setString(2, e.getEventTitle());
			ps.setString(3, e.getEventDescription());
			ps.setString(4, e.getEventStartDate());
			ps.setString(5, e.getEventEndDate());
			ps.setBoolean(6, false); // 預設為false
			ps.setString(7, Common.creaditDate());
			ps.setString(8, e.getEventImg());

			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public List<Events> getAllEvents() {

		List<Events> list = new ArrayList<Events>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from events";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Events e = new Events();
				e.setId(rs.getInt("id"));
				e.setEventId(rs.getString("eventId"));
				e.setEventTitle(rs.getString("eventTitle"));
				e.setEventDescription(rs.getString("eventDescription"));
				e.setEventStartDate(rs.getString("eventStartDate"));
				e.setEventEndDate(rs.getString("eventEndDate"));
				e.setEventIsPublish(rs.getBoolean("eventIsPublish"));
				e.setUpdateDate(rs.getString("updateDate"));
				e.setEventImg(rs.getString("eventImg"));

				list.add(e);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Events> getEventsById(int id) {
		List<Events> list = new ArrayList<Events>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from events where id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Events e = new Events();
				e.setId(rs.getInt("id"));
				e.setEventId(rs.getString("eventId"));
				e.setEventTitle(rs.getString("eventTitle"));
				e.setEventDescription(rs.getString("eventDescription"));
				e.setEventStartDate(rs.getString("eventStartDate"));
				e.setEventEndDate(rs.getString("eventEndDate"));
				e.setEventIsPublish(rs.getBoolean("eventIsPublish"));
				e.setUpdateDate(rs.getString("updateDate"));
				e.setEventImg(rs.getString("eventImg"));

				list.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Events> getEventsByPublish(boolean publish) {
		List<Events> list = new ArrayList<Events>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from events where eventIsPublish = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, publish);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Events e = new Events();
				e.setId(rs.getInt("id"));
				e.setEventId(rs.getString("eventId"));
				e.setEventTitle(rs.getString("eventTitle"));
				e.setEventDescription(rs.getString("eventDescription"));
				e.setEventStartDate(rs.getString("eventStartDate"));
				e.setEventEndDate(rs.getString("eventEndDate"));
				e.setEventIsPublish(rs.getBoolean("eventIsPublish"));
				e.setUpdateDate(rs.getString("updateDate"));
				e.setEventImg(rs.getString("eventImg"));

				list.add(e);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateEvents(Events e) {

		Connection conn = DbConnection.getDb();
		String sql = "update events set eventTitle=?,eventDescription=?,eventStartDate=?,eventEndDate=?,updateDate=? eventImg=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEventTitle());
			ps.setString(2, e.getEventDescription());
			ps.setString(3, e.getEventStartDate());
			ps.setString(4, e.getEventEndDate());
			ps.setString(5, Common.updateDate());
			ps.setInt(6, e.getId());
			ps.setString(7, e.getEventImg());

			ps.executeUpdate();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

	@Override
	public void updateEventPublish(Events e) { // 上下架
		Connection conn = DbConnection.getDb();
		String sql = "update events set eventIsPublish=? ,updateDate=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, e.getEventIsPublish());
			ps.setString(2, Common.updateDate());
			ps.setInt(3, e.getId());

			ps.executeUpdate();

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

	@Override
	public void deletedEvent(int id) { // 刪除活動
		Connection conn = DbConnection.getDb();
		String sql = "delete from events where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
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

		List<Events> list = getAllEvents();
		Events[] e = list.toArray(new Events[list.size()]);

		if ((e.length - 1) >= 0) {
			len = e[e.length - 1].getId();
		} else {
			len = 0;
		}
		return len;
	}
}
