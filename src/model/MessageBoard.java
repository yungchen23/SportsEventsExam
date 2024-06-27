package model;

public class MessageBoard {

	private int id;
	private String msgId;
	private String memberId;
	private String clubId;
	private String message;
	private String publishDate;
	private String updateDate;

	public MessageBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageBoard(String msgId, String memberId, String clubId, String message, String publishDate,
			String updateDate) {
		super();
		this.msgId = msgId;
		this.memberId = memberId;
		this.clubId = clubId;
		this.message = message;
		this.publishDate = publishDate;
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
