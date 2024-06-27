package service;

import java.util.List;

import model.views.getclubofmember;

public interface GetclubofmemberService {
	
	
	List<getclubofmember> getAllMember();
	List<getclubofmember> getMemberbyClub(String clubId);
	getclubofmember getLeaderbyClub(String clubId);
}
