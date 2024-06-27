package dao;

import java.util.List;

import model.views.getclubofmember;

public interface GetClubofMemberDao {
	
	
	List<getclubofmember> getAllMember();
	List<getclubofmember> getMemberbyClub(String clubId);
	getclubofmember getLeaderbyClub(String clubId);
	
	

}
