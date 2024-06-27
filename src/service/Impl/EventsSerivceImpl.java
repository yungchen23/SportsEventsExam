package service.Impl;

import java.util.List;

import dao.Impl.EventsDaoImpl;
import model.Clubs;
import model.Events;
import service.EventsSerivce;

public class EventsSerivceImpl implements EventsSerivce {

	public static void main(String[] args) {
		EventsSerivceImpl esi = new EventsSerivceImpl();

		Events evnet = new Events(null, "2024阿里山雲端馬拉松",
				" 海拔2000公尺以上的高山，阿里山擁有豐富的自然與人文資源，日出、雲海、森林、鐵道以及原住民文化，阿里山更是空氣清淨品質區域，全台唯一阿里山高山路跑，邀請您一同體驗高山之美及做公益。",
				"2024-08-01", "2024-08-31", null, null, null,null);
//		esi.addEvents(evnet);

//		List<Events> list = esi.getAllEvents();
//		for(Events x : list) {
//			System.out.println(x.getId()+"---"+x.getEventId()+"---"+x.getEventTitle()+"---"+x.getEventIsPublish());
//		}

		Events e2 = esi.getEventsById(4);
		System.out.println(e2.getEventTitle());
//		esi.updateEventPublish(4, true ,e2);

//		esi.deletedEvents(5);

	}

	private static EventsDaoImpl edi = new EventsDaoImpl();

	@Override
	public void addEvents(Events e) {
		edi.addEvents(e);
	}

	@Override
	public List<Events> getAllEvents() {
		return edi.getAllEvents();
	}

	@Override
	public List<Events> getEventsByPublish(boolean publish) {

		return edi.getEventsByPublish(publish);
	}

	@Override
	public Events getEventsById(int id) {
		List<Events> list = edi.getEventsById(id);
		if (list.size() != 0) {
			Events[] e = list.toArray(new Events[list.size()]);
			return e[0];
		} else {
			return null;
		}
	}

	@Override
	public void updateEvents(int id, Events event) {

		Events e = new EventsSerivceImpl().getEventsById(id);

		e.setEventTitle(event.getEventTitle());
		e.setEventDescription(event.getEventDescription());
		e.setEventStartDate(event.getEventStartDate());
		e.setEventEndDate(event.getEventEndDate());
		e.setUpdateDate(event.getUpdateDate());

		edi.updateEvents(e);
	}

	@Override // true上架 //false 下架
	public void updateEventPublish(int id, boolean publish, Events event) {
		Events e = new EventsSerivceImpl().getEventsById(id);

		e.setEventIsPublish(publish);
		e.setUpdateDate(event.getUpdateDate());

		edi.updateEventPublish(e);
	}

	@Override
	public void deletedEvents(int id) {
		edi.deletedEvent(id);
	}

}
