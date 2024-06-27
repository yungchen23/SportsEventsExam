package service;

import java.util.List;

import model.views.mangerbyclubinfo;

public interface MangerbyClubInfoService {
	
	List<mangerbyclubinfo> getAllMember();
	List<mangerbyclubinfo> getMemberbyClub(String clubId);

}
