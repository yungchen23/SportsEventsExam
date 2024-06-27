package model;

import java.io.Serializable;

public class Member implements Serializable{

	private int id;
	private String memberId;
	private String memberName;
	private String memberAccount;
	private String memberPassword;
	private String memberEmail;
	private String memberBirthday;
	private String memberGender;
	private String memberAge;
	private String memberPhone;
	private String memberLocation;
	private String memberIntroduction;
	private boolean status;
	private String createDate;
	private String updateDate;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberId, String memberName, String memberAccount, String memberPassword, boolean status, String createDate) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
		this.status = status;
		this.createDate = createDate;
	}
	
	
	
	public Member(String memberId, String memberName, String memberAccount, String memberPassword, String memberEmail,
			String memberBirthday, String memberGender, String memberAge, String memberPhone, String memberLocation,
			String memberIntroduction, boolean status, String createDate, String updateDate) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberAccount = memberAccount;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.memberBirthday = memberBirthday;
		this.memberGender = memberGender;
		this.memberAge = memberAge;
		this.memberPhone = memberPhone;
		this.memberLocation = memberLocation;
		this.memberIntroduction = memberIntroduction;
		this.status = status;
		this.createDate = createDate;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberLocation() {
		return memberLocation;
	}

	public void setMemberLocation(String memberLocation) {
		this.memberLocation = memberLocation;
	}

	public String getMemberIntroduction() {
		return memberIntroduction;
	}

	public void setMemberIntroduction(String memberIntroduction) {
		this.memberIntroduction = memberIntroduction;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
