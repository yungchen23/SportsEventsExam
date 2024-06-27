package dao;

import java.util.List;

import model.views.mangerbyclubinfo;

public interface MangerbyClubInfoDao {

	List<mangerbyclubinfo> getAllMember();
	List<mangerbyclubinfo> getMemberbyClub(String clubId);
	
}
