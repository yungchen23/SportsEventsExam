package service;

import java.util.List;

import model.Member;

public interface MemberService {

	//C
		void addMember(Member m);
		
		
	//R	
		List<Member> getAllMember();
		Member getMemberById(int id);
		Member getMemberByUser(String account);
		Member getMemberByUser2(String memberName);
		Member getMemberByUser(String account, String password);		

		
	//U
		void updateMember(int id,Member member);	//修改個人資料
		void updateMember(int id,String password);	//修改密碼
		
}
