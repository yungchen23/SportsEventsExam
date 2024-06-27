package service.Impl;

import java.util.List;

import dao.Impl.EventClubDaoImpl;
import model.EventClub;
import service.EventClubService;

public class EventClubServiceImpl implements EventClubService{

	public static void main(String[] args) {
		
	}

	private static EventClubDaoImpl ecdi = new EventClubDaoImpl();
	
	
	@Override
	public void joinEvents(EventClub ec) {
		ecdi.joinEvents(ec);
	}

	@Override
	public List<EventClub> getAllClubs() {
		return ecdi.getAllClubs();
	}

	@Override
	public EventClub getClubsById(int id) {
		List<EventClub> list =ecdi.getClubsById(id);
		EventClub[] ec = list.toArray(new EventClub[list.size()]);
			
		if(list.size()!=0) {
			return ec[0];
		}else {
			return null;
		}	
	}

	@Override
	public EventClub getRegisterStatus(String eventId, String clubId) {
		List<EventClub> list = ecdi.getRegisterStatus(eventId, clubId);
		EventClub[] ec = list.toArray(new EventClub[list.size()]);
		
		if(list.size()!=0) {
			return ec[0];
		}else {
			return null;
		}	
	}

	@Override
	public void updateRegister(int id, EventClub ec) {
		EventClub event = new EventClubServiceImpl().getClubsById(id);
		
		event.setJoinStatus(ec.getJoinStatus());
		event.setUpdateDate(ec.getUpdateDate());
		
		ecdi.updateRegister(event);	
	}

}
