package model;

public class NoticeMember {

	private int id;
	private String noticeId;
	private String memberId;
	private String clubId;
	private String topic;
	private String message;
	private String publishDate;

	public NoticeMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticeMember(String noticeId, String memberId, String clubId, String topic,String message, String publishDate) {
		super();
		this.noticeId = noticeId;
		this.memberId = memberId;
		this.clubId = clubId;
		this.topic = topic;
		this.message = message;
		this.publishDate = publishDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
