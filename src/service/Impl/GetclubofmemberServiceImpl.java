package service.Impl;

import java.util.List;

import model.MemberState;
import model.views.getclubofmember;
import dao.Impl.GetClubofMemberDaoImpl;
import service.GetclubofmemberService;

public class GetclubofmemberServiceImpl implements GetclubofmemberService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static GetClubofMemberDaoImpl gcmdi = new GetClubofMemberDaoImpl();
	
	@Override
	public List<getclubofmember> getAllMember() {
		return gcmdi.getAllMember();
	}

	@Override
	public List<getclubofmember> getMemberbyClub(String clubId) {

		return gcmdi.getMemberbyClub(clubId);
	}

	@Override
	public getclubofmember getLeaderbyClub(String clubId) {
		
		return gcmdi.getLeaderbyClub(clubId);
	}

}
