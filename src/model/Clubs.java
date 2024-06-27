package model;

import java.io.Serializable;

public class Clubs implements Serializable{

	private int id;
	private String clubId;
	private String clubName;
	private String clubLeaderId;
	private String clubIntroduction;
	private String clubBillboard; //6/20加入
	private String clubUrl;	// 6/18加入
	private String createDate;
	private String updateDate;

	public Clubs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clubs(String clubId, String clubName, String clubLeaderId, String clubIntroduction, String clubBillboard,String clubUrl,String createDate,
			String updateDate) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.clubLeaderId = clubLeaderId;
		this.clubIntroduction = clubIntroduction;
		this.clubBillboard= clubBillboard;
		this.clubUrl= clubUrl;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getClubLeaderId() {
		return clubLeaderId;
	}

	public void setClubLeaderId(String clubLeaderId) {
		this.clubLeaderId = clubLeaderId;
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

	public String getClubUrl() {
		return clubUrl;
	}

	public void setClubUrl(String clubUrl) {
		this.clubUrl = clubUrl;
	}

	public String getClubBillboard() {
		return clubBillboard;
	}

	public void setClubBillboard(String clubBillboard) {
		this.clubBillboard = clubBillboard;
	}

	
	
}
