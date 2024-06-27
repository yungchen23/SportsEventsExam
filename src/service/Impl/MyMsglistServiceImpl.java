package service.Impl;

import java.util.List;

import model.views.myMsglist;
import dao.MyMsglistDao;
import dao.Impl.MyMsglistDaoImpl;

public class MyMsglistServiceImpl implements MyMsglistDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static MyMsglistDaoImpl mMsg = new MyMsglistDaoImpl();
	
	@Override
	public List<myMsglist> getAllMsg() {
	
		return mMsg.getAllMsg();
	}

	@Override
	public List<myMsglist> getMsgbyClubs(String clubId) {
	
		return mMsg.getMsgbyClubs(clubId);
	}

}
