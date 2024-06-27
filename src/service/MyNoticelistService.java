package service;

import java.util.List;
import model.views.myNoticelist;

public interface MyNoticelistService {

	List<myNoticelist> getAllNotice();

	List<myNoticelist> getNoticebyClubs(String author);

}
