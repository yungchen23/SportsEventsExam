package dao;

import java.util.List;
import model.views.myNoticelist;

public interface MyNoticelistDao {

	// mynoticelist

	List<myNoticelist> getAllNotice();

	List<myNoticelist> getNoticebyClubs(String author);

}
