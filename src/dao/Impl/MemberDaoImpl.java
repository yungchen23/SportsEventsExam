package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.Common;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao {
	public static void main(String[] args) {
		
		MemberDaoImpl mdi = new MemberDaoImpl();
		

//		memberId,memberAccount,password,memberName,memberEmail,createDate
//		Member m = new Member(null, "天龍人3", "ccc", "111", "bbb@abc.com", null, null, null, null, null, null, true, null,
//				null);
//		new MemberDaoImpl().addMember(m);

//		List<Member> list = mdi.getAllMember();
//		System.out.println(list.size());
//		Member[] m = list.toArray(new Member[list.size()]);	
//		System.out.println(m.length);
		
//		Integer i = new MemberDaoImpl().getLatestId();
//		System.out.println("index=>"+i);
		
		
//		List<Member> list = new MemberDaoImpl().getMemberById(1);
		
//		List<Member> list= mdi.getAllMember();
//		
//		for (Member x : list) {
//			System.out.println(x.getMemberAccount() + "==" + x.getMemberName());
//		}
//		System.out.println("==========================================================");
				
		Member m2 = new MemberDaoImpl().getMemberById2("bbb", "111");
		System.out.println(m2);
		
//		List<Member>list2 = mdi.getMemberById("aaa1", "111");
//		for (Member x : list2) {
//			System.out.println(x.getMemberAccount() + "==" + x.getMemberName());
//		}
		
		
//		String sql = "update member set " 
//				+ "memberName=?, memberEmail=?, memberBirthday=?,"
//				+ "memberGender=?, memberAge=?, memberPhone=?,"
//				+ "memberLocation=?, memberIntroduction=?, updateDate=?"
//				+ "where id=?";
		
//		public Member(String memberId, String memberName, String memberAccount, String memberPassword, String memberEmail,
//				String memberBirthday, String memberGender, String memberAge, String memberPhone, String memberLocation,
//				String memberIntroduction, String status, String createDate, String updateDate) {
		
		
		
//		Member mm = new MemberDaoImpl().getMemberById2("bbb", "111");
//		
//		mm.setMemberName("鋤大B");
//		mm.setMemberEmail("123@cc.com");
//		mm.setMemberBirthday("1988-10-10");
//		mm.setMemberGender("男");
//		mm.setMemberPhone("888-8888-8888");
//		mm.setMemberLocation("樸克山");
//		mdi.updateMember(mm);
//
//		
//		System.out.println("==========================================================");
//		Member mm = new MemberDaoImpl().getMemberById2("bbb", "111");
//		mm.setMemberPassword("9999");
//		mdi.updateMemberPassword(mm);
//		
//		
//		List<Member> list3= mdi.getAllMember();
//		
//		for (Member x : list3) {
//			System.out.println(x.getMemberAccount() + "==" + x.getMemberName());
//		}
	}

	@Override
	public void addMember(Member m) {
		Connection conn = DbConnection.getDb();
		String sql = "insert into member(memberId,memberAccount,memberPassword,memberName,memberEmail,status,createDate) values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Common.formatNumber("m", new MemberDaoImpl().getLatestId()));
			ps.setString(2, m.getMemberAccount());
			ps.setString(3, m.getMemberPassword());
			ps.setString(4, m.getMemberName());
			ps.setString(5, m.getMemberEmail());
			ps.setBoolean(6, true); //帳號初始狀態為true 開通
			ps.setString(7, Common.creaditDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Member> getAllMember() {
		List<Member> list = new ArrayList<Member>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from member";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberId(rs.getString("memberId"));
				m.setMemberName(rs.getString("memberName"));
				m.setMemberAccount(rs.getString("memberAccount"));
				m.setMemberPassword(rs.getString("memberPassword"));
				m.setMemberEmail(rs.getString("memberEmail"));
				m.setMemberBirthday(rs.getString("memberBirthday"));
				m.setMemberGender(rs.getString("memberGender"));
				m.setMemberAge(rs.getString("memberAge"));
				m.setMemberPhone(rs.getString("memberPhone"));
				m.setMemberLocation(rs.getString("memberLocation"));
				m.setMemberIntroduction(rs.getString("memberIntroduction"));
				m.setStatus(rs.getBoolean("status"));
				m.setCreateDate(rs.getString("createDate"));
				m.setUpdateDate(rs.getString("updateDate"));

				list.add(m);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Member> getMemberById(int id) {
		List<Member> list = new ArrayList<Member>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from member where id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberId(rs.getString("memberId"));
				m.setMemberName(rs.getString("memberName"));
				m.setMemberAccount(rs.getString("memberAccount"));
				m.setMemberPassword(rs.getString("memberPassword"));
				m.setMemberEmail(rs.getString("memberEmail"));
				m.setMemberBirthday(rs.getString("memberBirthday"));
				m.setMemberGender(rs.getString("memberGender"));
				m.setMemberAge(rs.getString("memberAge"));
				m.setMemberPhone(rs.getString("memberPhone"));
				m.setMemberLocation(rs.getString("memberLocation"));
				m.setMemberIntroduction(rs.getString("memberIntroduction"));
				m.setStatus(rs.getBoolean("status"));
				m.setCreateDate(rs.getString("createDate"));
				m.setUpdateDate(rs.getString("updateDate"));

				list.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Member> getMemberByUser(String account) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from member where memberAccount = ? ";
		List<Member> list = new ArrayList<Member>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberId(rs.getString("memberId"));
				m.setMemberName(rs.getString("memberName"));
				m.setMemberAccount(rs.getString("memberAccount"));
				m.setMemberPassword(rs.getString("memberPassword"));
				m.setMemberEmail(rs.getString("memberEmail"));
				m.setMemberBirthday(rs.getString("memberBirthday"));
				m.setMemberGender(rs.getString("memberGender"));
				m.setMemberAge(rs.getString("memberAge"));
				m.setMemberPhone(rs.getString("memberPhone"));
				m.setMemberLocation(rs.getString("memberLocation"));
				m.setMemberIntroduction(rs.getString("memberIntroduction"));
				m.setStatus(rs.getBoolean("status"));
				m.setCreateDate(rs.getString("createDate"));
				m.setUpdateDate(rs.getString("updateDate"));
				
				list.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	

	@Override
	public List<Member> getMemberByUser2(String memberName) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from member where memberName = ? ";
		List<Member> list = new ArrayList<Member>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, memberName);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberId(rs.getString("memberId"));
				m.setMemberName(rs.getString("memberName"));
				m.setMemberAccount(rs.getString("memberAccount"));
				m.setMemberPassword(rs.getString("memberPassword"));
				m.setMemberEmail(rs.getString("memberEmail"));
				m.setMemberBirthday(rs.getString("memberBirthday"));
				m.setMemberGender(rs.getString("memberGender"));
				m.setMemberAge(rs.getString("memberAge"));
				m.setMemberPhone(rs.getString("memberPhone"));
				m.setMemberLocation(rs.getString("memberLocation"));
				m.setMemberIntroduction(rs.getString("memberIntroduction"));
				m.setStatus(rs.getBoolean("status"));
				m.setCreateDate(rs.getString("createDate"));
				m.setUpdateDate(rs.getString("updateDate"));
				
				list.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	

	@Override
	public List<Member> getMemberByUser(String account, String password) {
		
		Connection conn = DbConnection.getDb();
		String sql = "select * from member where memberAccount = ? and memberPassword =?";
		List<Member> list = new ArrayList<Member>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberId(rs.getString("memberId"));
				m.setMemberName(rs.getString("memberName"));
				m.setMemberAccount(rs.getString("memberAccount"));
				m.setMemberPassword(rs.getString("memberPassword"));
				m.setMemberEmail(rs.getString("memberEmail"));
				m.setMemberBirthday(rs.getString("memberBirthday"));
				m.setMemberGender(rs.getString("memberGender"));
				m.setMemberAge(rs.getString("memberAge"));
				m.setMemberPhone(rs.getString("memberPhone"));
				m.setMemberLocation(rs.getString("memberLocation"));
				m.setMemberIntroduction(rs.getString("memberIntroduction"));
				m.setStatus(rs.getBoolean("status"));
				m.setCreateDate(rs.getString("createDate"));
				m.setUpdateDate(rs.getString("updateDate"));
				
				list.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	
	@Override
	public Member getMemberById2(String account, String password) {
		Member m = null;

		Connection conn = DbConnection.getDb();
		String sql = "select * from member where memberAccount = ? and memberPassword =?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				m = new Member();
				m.setId(rs.getInt("id"));
				m.setMemberId(rs.getString("memberId"));
				m.setMemberName(rs.getString("memberName"));
				m.setMemberAccount(rs.getString("memberAccount"));
				m.setMemberPassword(rs.getString("memberPassword"));
				m.setMemberEmail(rs.getString("memberEmail"));
				m.setMemberBirthday(rs.getString("memberBirthday"));
				m.setMemberGender(rs.getString("memberGender"));
				m.setMemberAge(rs.getString("memberAge"));
				m.setMemberPhone(rs.getString("memberPhone"));
				m.setMemberLocation(rs.getString("memberLocation"));
				m.setMemberIntroduction(rs.getString("memberIntroduction"));
				m.setStatus(rs.getBoolean("status"));
				m.setCreateDate(rs.getString("createDate"));
				m.setUpdateDate(rs.getString("updateDate"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}



	@Override
	public void updateMember(Member m) {
		Connection conn = DbConnection.getDb();
		String sql = "update member set " 
				+ "memberName=?, memberEmail=?, memberBirthday=?,"
				+ "memberGender=?, memberAge=?, memberPhone=?,"
				+ "memberLocation=?, memberIntroduction=?, updateDate=?"
				+ "where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getMemberName());
			ps.setString(2, m.getMemberEmail());
			ps.setString(3, m.getMemberBirthday());
			ps.setString(4, m.getMemberGender());
			ps.setString(5, Common.currentAge(m.getMemberBirthday()));			
			ps.setString(6, m.getMemberPhone());
			ps.setString(7, m.getMemberLocation());
			ps.setString(8, m.getMemberIntroduction());
			ps.setString(9, Common.updateDate());
			ps.setInt(10, m.getId());
			
			ps.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMemberPassword(Member m) {
		Connection conn = DbConnection.getDb();
		String sql = "update member set  memberPassword=? ,updateDate=? where id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getMemberPassword());
			ps.setString(2, Common.updateDate());
			ps.setInt(3, m.getId());	
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer getLatestId() { // 取得最新一筆id
		Integer len =null;
		List<Member> list = getAllMember();
		Member[] m = list.toArray(new Member[list.size()]);	
		
		System.out.println(m.length - 1);
		
		if((m.length - 1)>=0) {
			len =m[m.length - 1].getId();
			System.out.println(len);
		}else {
			len = 0;
		}
//		System.out.println(len);
		return len;
	}

	@Override
	public void updateMemberStatus(Member m) {
		// TODO Auto-generated method stub
		
	}

}
