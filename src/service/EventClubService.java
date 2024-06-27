package service;

import java.util.List;

import model.EventClub;

public interface EventClubService {

	//C  //第一次加入 
	void joinEvents(EventClub ec);
	
	
	//R
	List<EventClub> getAllClubs();
	EventClub getClubsById(int id);
	EventClub getRegisterStatus(String eventId ,String clubId); //查詢是否已經報名
	
	//U  
	void updateRegister(int id,EventClub ec);	//更改報名狀態
	
}
