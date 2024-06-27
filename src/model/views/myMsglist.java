package model.views;

public class myMsglist {

	private Integer ID;
	private String memberId;
	private String memberName;
	private String clubId;
	private String message;
	private String publishDate;

	public myMsglist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public myMsglist(Integer ID, String memberId, String memberName, String clubId, String message, String publishDate) {
		super();
		this.ID = ID;
		this.memberId = memberId;
		this.memberName = memberName;
		this.clubId = clubId;
		this.message = message;
		this.publishDate = publishDate;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

}
