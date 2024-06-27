package model.views;

public class getclubofmember {

	private int ID;
	private String CLUBID;
	private String CLUBNAME;
	private String MAMBERNAME;
	private String TITLE;
	private String LEVEL;
	private String JOINTIME;
	private String UPDATETIME;

	public getclubofmember() {
		super();
	}

	public getclubofmember(String cLUBID, String cLUBNAME, String mAMBERNAME, String tITLE, String lEVEL,
			String jOINTIME, String uPDATETIME) {
		super();
		CLUBID = cLUBID;
		CLUBNAME = cLUBNAME;
		MAMBERNAME = mAMBERNAME;
		TITLE = tITLE;
		LEVEL = lEVEL;
		JOINTIME = jOINTIME;
		UPDATETIME = uPDATETIME;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCLUBID() {
		return CLUBID;
	}

	public void setCLUBID(String cLUBID) {
		CLUBID = cLUBID;
	}

	public String getCLUBNAME() {
		return CLUBNAME;
	}

	public void setCLUBNAME(String cLUBNAME) {
		CLUBNAME = cLUBNAME;
	}

	public String getMAMBERNAME() {
		return MAMBERNAME;
	}

	public void setMAMBERNAME(String mAMBERNAME) {
		MAMBERNAME = mAMBERNAME;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getLEVEL() {
		return LEVEL;
	}

	public void setLEVEL(String lEVEL) {
		LEVEL = lEVEL;
	}

	public String getJOINTIME() {
		return JOINTIME;
	}

	public void setJOINTIME(String jOINTIME) {
		JOINTIME = jOINTIME;
	}

	public String getUPDATETIME() {
		return UPDATETIME;
	}

	public void setUPDATETIME(String uPDATETIME) {
		UPDATETIME = uPDATETIME;
	}

}
