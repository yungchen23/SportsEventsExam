package dao;

import java.util.List;

import model.MemberState;

public interface MemberStateDao {
	
	//部分功能與ClubsDao，ClubsService關聯
	
	//C 
	void createClub(MemberState ms);	//創建社團
	void joinClub(MemberState ms);		//加入社團
	
	//R
	List<MemberState> getAllMemberofClub();
	List<MemberState> getClubById(String clubId);  //查詢指定社團

	MemberState getClubByMember(String memberId);  //查詢單一團員	

	
	
	//U
	void updateLevel(MemberState ms);  //修改社團成員權限	
	void updateClubByMember(MemberState ms);  //加入社團(成員貼上社團)
	//D
	void deletedClub(String clubId);         //解散社團
	
	
	
}
