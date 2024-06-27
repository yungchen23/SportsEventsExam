package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberStateDao;
import model.Member;
import model.MemberState;
import service.Impl.MemberStateServiceImpl;
import util.Common;
import util.DbConnection;

public class MemberStateDaoImpl implements MemberStateDao {

	public static void main(String[] args) {

		MemberStateDaoImpl msdi = new MemberStateDaoImpl();

		MemberState ms = new MemberState("m00001", "c00001", true, false, "1", null,null);
//		msdi.createClub(ms);
//		msdi.joinClub(ms);
//		List<MemberState> list =msdi.getAllMemberofClub();
//		List<MemberState> list =msdi.getClubByLeader("m00002",true);
	
		
//		msdi.getClubByMember(ms).forEach((x)->System.out.println(x.getId() + "-" + x.getMemberId() + "-" + x.getClubId()));
//		msdi.getClubById("c00001").forEach((x)->System.out.println(x.getId() + "-" + x.getMemberId() + "-" + x.getClubId()));
//		msdi.deletedClub("c00001");
//		MemberState a = msdi.getClubByMember(ms);
//		System.out.println(a.getIsGroupMember());
		
		
		Member member = new Member("m00011", null, null, null, false, null);
		MemberState ms1 = new MemberStateDaoImpl().getClubByMember(member.getMemberId());
		System.out.println(ms1);
		System.out.println(ms1.getMemberId());
		
		
		
	}

	@Override
	public void createClub(MemberState ms) {

		Connection conn = DbConnection.getDb();
		String sql = "insert into memberState (memberId, clubId, isLeader, isGroupMember, level,joinDate) values (?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ms.getMemberId());
			ps.setString(2, ms.getClubId());
			ps.setBoolean(3, ms.getIsLeader());
			ps.setBoolean(4, ms.getIsGroupMember());
			ps.setString(5, ms.getLevel());
			ps.setString(6, Common.joinDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void joinClub(MemberState ms) {
		Connection conn = DbConnection.getDb();
		String sql = "insert into memberState (memberId, clubId, isLeader, isGroupMember, level,joinDate) values (?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ms.getMemberId());
			ps.setString(2, ms.getClubId());
			ps.setBoolean(3, ms.getIsLeader());	
			ps.setBoolean(4, ms.getIsGroupMember());
			ps.setString(5, ms.getLevel());	
			ps.setString(6, Common.joinDate());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberState> getAllMemberofClub() {
		List<MemberState> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from MemberState";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MemberState ms = new MemberState();
				ms.setId(rs.getInt("id"));
				ms.setMemberId(rs.getString("memberId"));
				ms.setClubId(rs.getString("clubId"));
				ms.setIsLeader(rs.getBoolean("isLeader"));
				ms.setIsGroupMember(rs.getBoolean("isGroupMember"));
				ms.setLevel(rs.getString("level"));
				ms.setJoinDate(rs.getString("joinDate"));
				ms.setUpdateDate(rs.getString("updateDate"));

				list.add(ms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberState> getClubById(String clubId) {
		List<MemberState> list = new ArrayList<>();

		Connection conn = DbConnection.getDb();
		String sql = "select * from MemberState where clubId=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, clubId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MemberState ms = new MemberState();
				ms.setId(rs.getInt("id"));
				ms.setMemberId(rs.getString("memberId"));
				ms.setClubId(rs.getString("clubId"));
				ms.setIsLeader(rs.getBoolean("isLeader"));
				ms.setIsGroupMember(rs.getBoolean("isGroupMember"));
				ms.setLevel(rs.getString("level"));
				ms.setJoinDate(rs.getString("joinDate"));
				ms.setUpdateDate(rs.getString("updateDate"));

				list.add(ms);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

//	@Override
//	public List<MemberState> getClubByLeader(String memberId, boolean isLeader) {
//		List<MemberState> list = new ArrayList<>();
//
//		Connection conn = DbConnection.getDb();
//		String sql = "select * from MemberState where memberId=? and isLeader=?";
//
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, memberId);
//			ps.setBoolean(2, isLeader);
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next()) {
//				MemberState ms = new MemberState();
//				ms.setId(rs.getInt("id"));
//				ms.setMemberId(rs.getString("memberId"));
//				ms.setClubId(rs.getString("clubId"));
//				ms.setIsLeader(rs.getBoolean("isLeader"));
//				ms.setIsGroupMember(rs.getBoolean("isGroupMember"));
//				ms.setLevel(rs.getString("level"));
//				ms.setJoinDate(rs.getString("joinDate"));
//				ms.setUpdateDate(rs.getString("updateDate"));
//
//				list.add(ms);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

	@Override
	public MemberState getClubByMember(String memberId) {  //可用memberId
//		List<MemberState> list = new ArrayList<>();
	
		MemberState ms=null;
		
		Connection conn = DbConnection.getDb();
		String sql = "select * from MemberState where memberId=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, ms.getMemberId());
			ps.setString(1, memberId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ms = new MemberState();
				ms.setId(rs.getInt("id"));
				ms.setMemberId(rs.getString("memberId"));
				ms.setClubId(rs.getString("clubId"));
				ms.setIsLeader(rs.getBoolean("isLeader"));
				ms.setIsGroupMember(rs.getBoolean("isGroupMember"));
				ms.setLevel(rs.getString("level"));
				ms.setJoinDate(rs.getString("joinDate"));
				ms.setUpdateDate(rs.getString("updateDate"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ms;
	}
	
	
	
	@Override
	public void updateLevel(MemberState ms) {
		Connection conn = DbConnection.getDb();
		String sql = "update memberState set level=?,updateDate=? where memberId=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ms.getLevel());
			ps.setString(2, Common.updateDate());
			ps.setString(3, ms.getMemberId());

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	
	@Override
	public void updateClubByMember(MemberState ms) {
		Connection conn = DbConnection.getDb();
		String sql = "update memberState set clubId=?,updateDate=? where memberId=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ms.getClubId());
			ps.setString(2, Common.updateDate());
			ps.setString(3, ms.getMemberId());

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deletedClub(String clubId) {
		Connection conn = DbConnection.getDb();
		String sql = "delete from memberState where clubId=?";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, clubId);

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	


}
