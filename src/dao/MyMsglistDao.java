package dao;

import java.util.List;

import model.views.myMsglist;

public interface MyMsglistDao {

	
	List<myMsglist> getAllMsg();

	List<myMsglist> getMsgbyClubs(String clubId);
	
}
