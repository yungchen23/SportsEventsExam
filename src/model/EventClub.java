package model;

public class EventClub {
	private int id;
	private String eventId;
	private String clubId;
	private boolean joinStatus;
	private String joinDate;
	private String updateDate;

	public EventClub() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventClub(String eventId, String clubId, boolean joinStatus, String joinDate, String updateDate) {
		super();
		this.eventId = eventId;
		this.clubId = clubId;
		this.joinStatus = joinStatus;
		this.joinDate = joinDate;
		this.updateDate = updateDate;
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

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public boolean getJoinStatus() {
		return joinStatus;
	}

	public void setJoinStatus(boolean joinStatus) {
		this.joinStatus = joinStatus;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
