package model;

import java.io.Serializable;

public class Events implements Serializable {

	private int id;
	private String eventId;
	private String eventTitle;
	private String eventDescription;
	private String eventStartDate;
	private String eventEndDate;
	private Boolean eventIsPublish;
	private String createDate;
	private String updateDate;
	private String eventImg;

	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Events(String eventId, String eventTitle, String eventDescription, String eventStartDate,
			String eventEndDate, Boolean eventIsPublish, String createDate, String updateDate, String eventImg) {
		super();
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.eventDescription = eventDescription;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.eventIsPublish = eventIsPublish;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.eventImg = eventImg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public Boolean getEventIsPublish() {
		return eventIsPublish;
	}

	public void setEventIsPublish(Boolean eventIsPublish) {
		this.eventIsPublish = eventIsPublish;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getEventImg() {
		return eventImg;
	}

	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
	}

}
