package dao;

import java.util.List;

import model.MessageBoard;

public interface MessageBoardDao {
	

	
	//C
	void addMsg(MessageBoard msg);
	
	
	//R
	List<MessageBoard> getAllMsg();
	List<MessageBoard> getMsgById(int id);			 //查詢留言id
	List<MessageBoard> getMsgByClub(String clubId);  //查詢指定社團留言
	Integer getLatestId(); //返回已存在最後一筆id
	
	
	//U
	void updateMsg(MessageBoard msg);	//編輯留言
	
	
	//D
	void deletedMsg(int id);  //刪除留言

}
