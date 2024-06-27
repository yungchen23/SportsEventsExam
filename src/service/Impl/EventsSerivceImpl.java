package service.Impl;

import java.util.List;

import dao.Impl.EventsDaoImpl;
import model.Clubs;
import model.Events;
import service.EventsSerivce;

public class EventsSerivceImpl implements EventsSerivce {

	public static void main(String[] args) {

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
