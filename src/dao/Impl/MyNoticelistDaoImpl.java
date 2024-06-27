package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MyNoticelistDao;
import model.views.myNoticelist;
import util.DbConnection;

public class MyNoticelistDaoImpl implements MyNoticelistDao{

	public static void main(String[] args) {
		
//		List<mynoticelist> l = new mynoticelistDaoImpl().getAllNotice();
		 List<myNoticelist> l = new MyNoticelistDaoImpl().getNoticebyClubs("高雄天龍國");
		 l.forEach((x)->System.out.println(x.getId()+"-"+x.getAuthor()+"-"+x.getTopic()+"-"+x.getMessage()));
	}

	@Override
	public List<myNoticelist> getAllNotice() {
		
		List<myNoticelist> list = new ArrayList<>();
		
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM mynoticelist";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				myNoticelist no = new myNoticelist();
				no.setId(rs.getInt("index"));
				no.setAuthor(rs.getString("author"));
				no.setTopic(rs.getString("topic"));
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
	public List<myNoticelist> getNoticebyClubs(String author) {
List<myNoticelist> list = new ArrayList<>();
		
		Connection conn = DbConnection.getDb();
		String sql = "SELECT * FROM mynoticelist where author=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, author);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				myNoticelist no = new myNoticelist();
				no.setId(rs.getInt("index"));
				no.setAuthor(rs.getString("author"));
				no.setTopic(rs.getString("topic"));
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
