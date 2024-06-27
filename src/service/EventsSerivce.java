package service;

import java.util.List;

import model.Events;


public interface EventsSerivce {


	// C
	void addEvents(Events e);

	// R
	List<Events> getAllEvents();
	List<Events> getEventsByPublish(boolean publish);
	Events getEventsById(int id);

	
	//U
	void updateEvents(int id,Events event);	//編輯社團
	void updateEventPublish(int id, boolean publish ,Events event); //活動上架true/下架false	
		
	//D
	void deletedEvents(int id);  //刪除活動
	
	
	
	
}
