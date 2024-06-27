package service.Impl;

import java.util.List;

import dao.Impl.EventClubDaoImpl;
import model.EventClub;
import service.EventClubService;

public class EventClubServiceImpl implements EventClubService{

	public static void main(String[] args) {
		
		EventClub ec = new EventClub("e00002", "c00002", true, null, null);
		new EventClubServiceImpl().joinEvents(ec);
//		
//		List<EventClub> l = new EventClubServiceImpl().getAllClubs();
//		l.forEach((x)->System.out.println(x.getId()+"-"+x.getEventId()+"-"+x.getClubId()+"-"+x.getJoinDate()));
//		System.out.println("---------------------------------------");
//		EventClub x =new EventClubServiceImpl().getClubsById(5);
//		System.out.println(x.getId()+"-"+x.getEventId()+"-"+x.getClubId()+"-"+x.getJoinDate());
		
//		EventClub ec = new EventClub();
//		ec.setJoinStatus(true);
//		new EventClubServiceImpl().updateRegister(6, ec);
		
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
