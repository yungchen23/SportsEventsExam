package model.views;

public class mangerbyclubinfo {

	private String clubId;
	private String clubName;
	private String clubLeader;
	private Integer NumberofMembers;
	private String clubIntroduction;
	private String createDate;
	private String updateDate;

	public mangerbyclubinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubLeader() {
		return clubLeader;
	}

	public void setClubLeader(String clubLeader) {
		this.clubLeader = clubLeader;
	}

	public Integer getNumberofMembers() {
		return NumberofMembers;
	}

	public void setNumberofMembers(Integer numberofMembers) {
		NumberofMembers = numberofMembers;
	}

	public String getClubIntroduction() {
		return clubIntroduction;
	}

	public void setClubIntroduction(String clubIntroduction) {
		this.clubIntroduction = clubIntroduction;
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

}
