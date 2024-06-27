package service.Impl;

import java.util.List;

import dao.Impl.MemberStateDaoImpl;
import model.Clubs;
import model.Member;
import model.MemberState;
import service.MemberStateService;

public class MemberStateServiceImpl implements MemberStateService {

	public static void main(String[] args) {

		MemberStateServiceImpl mssi = new MemberStateServiceImpl();

		MemberState ms = new MemberState("m00005", "c00002", true, false, null, null, null);
//		mssi.createClub(ms);
		Member member = new Member("m00016", null, null, null, false, null);
		boolean xx = new MemberStateServiceImpl().getUsetIsClubLeader(member);
		boolean xx2 = new MemberStateServiceImpl().getUsetIsClubmember(member);

		System.out.println(xx);
		System.out.println(xx);
		System.out.println("-------------------------");
//		MemberState ms2 = new MemberState("m00007", "c00001", false, true,"1", null,null);
//		mssi.joinClub(ms2);

		mssi.getAllMemberofClub()
				.forEach((x) -> System.out.println(x.getId() + "-" + x.getMemberId() + "-" + x.getClubId()));
		System.out.println("----------------------");
//		mssi.deletedClub("c00003");
		mssi.getClubById("c00003")
				.forEach((mx) -> System.out.println(mx.getId() + "-" + mx.getMemberId() + "-" + mx.getClubId()));

//		MemberState ms = mssi.getClubByMember("m00002");
//		ms.setLevel("2");
//		mssi.updateLevel("m00002", ms);

//		Clubs cc2 = new Clubs();
//		Clubs cc2 = csi.getClubsById(8);
//		cc2.setClubName("高雄天龍國");
//		csi.updateClubsName(8, cc2);  //還沒測試
		System.out.println("----------------------");
//		MemberState ms =mssi.getClubByLeader("m00001", true);
//		System.out.println(ms.getClubId());

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
//	
//	@Override
//	public MemberState getClubByLeader(String memberId, boolean isLeader) {
//		
//		List<MemberState> list = msdi.getClubByLeader(memberId, isLeader);
//		MemberState[] ms = list.toArray(new MemberState[list.size()]);
//		
//		return ms[0];
//	}

	
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
	

	
//	@Override
//	public boolean getUsetIsClubmember(Member member) {
//		MemberState m = null;
//		if (member.getMemberId() != null) {
//			
//			m = msdi.getClubByMember(member.getMemberId());
//
//			return m.getIsGroupMember();
//		} else {
//			return false;
//		}
//	}
//
//	@Override
//	public boolean getUsetIsClubLeader(Member member) {
//		MemberState m = null;
//
//		if (member.getMemberId() != null) {
//			m = msdi.getClubByMember(member.getMemberId());
//			return m.getIsLeader();
//
//		} else {
//			return false;
//		}
//	}

	@Override
	public void updateLevel(MemberState memberstate) {

//		MemberState mss = new MemberStateServiceImpl().getClubByMember(memberId);
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
