package service.Impl;

import java.util.List;

import dao.Impl.MemberStateDaoImpl;
import model.Clubs;
import model.Member;
import model.MemberState;
import service.MemberStateService;

public class MemberStateServiceImpl implements MemberStateService {

	public static void main(String[] args) {

	}

	private static MemberStateDaoImpl msdi = new MemberStateDaoImpl();

	@Override
	public void createClub(MemberState ms,Clubs club) {
		ms.setClubId(club.getClubId());
		ms.setIsLeader(true);
		ms.setIsGroupMember(false);
		ms.setLevel("99");
		msdi.createClub(ms);
	}

	@Override
	public void joinClub(MemberState ms,String ClubsID) {		
		ms.setClubId(ClubsID);
		ms.setIsLeader(false);
		ms.setIsGroupMember(true);
		ms.setLevel("1");
		msdi.joinClub(ms);
	}

	@Override
	public List<MemberState> getAllMemberofClub() {

		return msdi.getAllMemberofClub();
	}

	@Override
	public List<MemberState> getClubById(String clubId) { // 查詢指定社團
		return msdi.getClubById(clubId);
	}

	@Override
	public MemberState getClubByMember(String memberId) { // 查詢單一團員
		MemberState m = msdi.getClubByMember(memberId);
		return m;
	}

	
	//把共同的部分提取出來
	private MemberState getMemberState(Member member) {
		MemberState m = null;
		if (member!= null && member.getMemberId() != null) {
			
			return msdi.getClubByMember(member.getMemberId());
		}
		return null;
	}
	
	@Override
	public boolean getUsetIsClubmember(Member member) {

		MemberState memberState = getMemberState(member);
		
		return memberState != null && memberState.getIsGroupMember();
	}
	
	
	@Override
	public boolean getUsetIsClubLeader(Member member) {

		MemberState memberState = getMemberState(member);
		
		return memberState != null && memberState.getIsLeader();	
	}
	
	@Override
	public void updateLevel(MemberState memberstate) {

		MemberState ms1 = new MemberStateServiceImpl().getClubByMember(memberstate.getMemberId());

		ms1.setLevel(memberstate.getLevel());
		ms1.setUpdateDate(memberstate.getUpdateDate());
		msdi.updateLevel(ms1);
	}

	@Override
	public void updateClubByMember(String ClubId, MemberState ms) {
		MemberState ms1 = new MemberStateServiceImpl().getClubByMember(ms.getMemberId());
		ms1.setClubId(ClubId);
		ms1.setUpdateDate(ms.getUpdateDate());
		msdi.updateClubByMember(ms);
	}

	
	
	
	@Override
	public void deletedClub(String clubId) {
		msdi.deletedClub(clubId);
	}


}
