package dao;

import java.util.List;

import model.Events;

public interface EventsDao {
	

	
	// C
	void addEvents(Events e);

	// R
	List<Events> getAllEvents();
	List<Events> getEventsById(int id);
	List<Events> getEventsByPublish(boolean publish);
	Integer getLatestId(); //返回已存在最後一筆id
	
	//U
	void updateEvents(Events e);	//修改社團
	void updateEventPublish(Events e); //活動下架/上架	
	
	
	//D
	void deletedEvent(int id);  //刪除單一活動	

	
	

}
