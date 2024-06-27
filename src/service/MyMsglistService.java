package service;

import java.util.List;

import model.views.myMsglist;

public interface MyMsglistService {
	
	
	List<myMsglist> getAllMsg();

	List<myMsglist> getMsgbyClubs(String clubId);

}
