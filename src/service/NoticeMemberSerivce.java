package service;

import java.util.List;

import model.NoticeMember;

public interface NoticeMemberSerivce {

	//C
		void addMsg(NoticeMember notice);
		
		//R
		List<NoticeMember> getAllNotice();
		NoticeMember getNoticeById(int id);			 //查詢指定id
		List<NoticeMember>  getNoticeByMember(String memberId);  //查詢指定個人通知
		List<NoticeMember> getNoticeByClub(String clubId);  //查詢指定社團通知
	
		
		//D
		void deletedNotice(int id);  //刪除留言

	
}
