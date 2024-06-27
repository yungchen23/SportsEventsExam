package service;

import java.util.List;

import model.MessageBoard;

public interface MessageBoardService {


	//C
	void addMsg(MessageBoard msg);
	
	
	//R
	List<MessageBoard> getAllMsg();
	MessageBoard getMsgById(int id);			 //查詢留言id
	List<MessageBoard> getMsgByClub(String clubId);   //查詢指定社團留言
		
	
	//U
	void updateMsg(int id,MessageBoard msg);	//編輯留言
	
	
	//D
	void deletedMsg(int id);  //刪除留言
	
}
