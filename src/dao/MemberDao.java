package dao;

import java.util.List;

import model.Member;

public interface MemberDao {

	//C
	void addMember(Member m);
	
	//R
	List<Member> getAllMember();
	List<Member> getMemberById(int id);	
	List<Member> getMemberByUser(String account); //驗證帳號重複用
	List<Member> getMemberByUser(String account, String password); //驗證帳號密碼用
	List<Member> getMemberByUser2(String memberName); //驗證帳號重複用
	Member  getMemberById2(String account, String password); //驗證帳號密碼用(參考用)

//	Integer getCountAllMembers(); //統計所有會員人數 (返回已存在最後一筆id)
	Integer getLatestId(); //返回已存在最後一筆id
	
	
	//U
	void updateMember(Member m);			//修改個人資料
	void updateMemberPassword(Member m);	//修改密碼

	void updateMemberStatus(Member m); 		//修改帳號狀態  //T 開通  F封鎖
	
	
	
	
}
