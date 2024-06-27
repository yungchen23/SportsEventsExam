package dao;

import java.util.List;

import model.EventClub;

public interface EventClubDao {

	//C  //第一次加入 
	void joinEvents(EventClub ec);
	
	
	//R
	List<EventClub> getAllClubs();
	List<EventClub> getClubsById(int id);
	List<EventClub> getRegisterStatus(String eventId ,String clubId);
	
	
	//U  
	void updateRegister(EventClub ec);	//變更報名
	
	
}
