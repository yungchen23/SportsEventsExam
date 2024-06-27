package model;

import java.io.Serializable;

public class MemberState implements Serializable{

	private int id;
	private String memberId;
	private String clubId;
	private Boolean isLeader;
	private Boolean isGroupMember;
	private String level;
	private String joinDate;
	private String updateDate;

	public MemberState() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberState(String memberId, String clubId, Boolean isLeader, Boolean isGroupMember, String level,
			String joinDate,String updateDate) {
		super();
		this.memberId = memberId;
		this.clubId = clubId;
		this.isLeader = isLeader;
		this.isGroupMember = isGroupMember;
		this.level = level;
		this.joinDate= joinDate;
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Boolean getIsLeader() {
		return isLeader;
	}

	public void setIsLeader(Boolean isLeader) {
		this.isLeader = isLeader;
	}

	public Boolean getIsGroupMember() {
		return isGroupMember;
	}

	public void setIsGroupMember(Boolean isGroupMember) {
		this.isGroupMember = isGroupMember;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

}
