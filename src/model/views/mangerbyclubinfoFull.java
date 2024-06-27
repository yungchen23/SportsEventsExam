package model.views;

public class mangerbyclubinfoFull {

	private String Mid;
	private String name;
	private String account;
	private String gender;
	private String age;
	private String birthday;
	private String Email;
	private String phone;
	private String location;
	private String joinclub;
	private String status;
	private String createDate;

	public mangerbyclubinfoFull() {
		super();
		// TODO Auto-generated constructor stub
	}

	public mangerbyclubinfoFull(String mid, String name, String account, String gender, String age, String birthday,
			String email, String phone, String location, String joinclub, String status, String createDate) {
		super();
		Mid = mid;
		this.name = name;
		this.account = account;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		Email = email;
		this.phone = phone;
		this.location = location;
		this.joinclub = joinclub;
		this.status = status;
		this.createDate = createDate;
	}

	public String getMid() {
		return Mid;
	}

	public void setMid(String mid) {
		Mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJoinclub() {
		return joinclub;
	}

	public void setJoinclub(String joinclub) {
		this.joinclub = joinclub;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
