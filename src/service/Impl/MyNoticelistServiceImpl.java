package service.Impl;

import java.util.List;

import model.views.myNoticelist;
import dao.Impl.MyNoticelistDaoImpl;
import service.MyNoticelistService;

public class MyNoticelistServiceImpl implements MyNoticelistService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static MyNoticelistDaoImpl mtdi = new MyNoticelistDaoImpl();
	
	@Override
	public List<myNoticelist> getAllNotice() {
		return mtdi.getAllNotice();
	}

	@Override
	public List<myNoticelist> getNoticebyClubs(String author) {
		return mtdi.getNoticebyClubs(author);
	}

}
