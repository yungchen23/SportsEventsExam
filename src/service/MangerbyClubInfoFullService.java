package service;

import java.util.List;

import model.views.mangerbyclubinfoFull;

public interface MangerbyClubInfoFullService {

	List<mangerbyclubinfoFull> getAllMember();
	List<mangerbyclubinfoFull> getMemberbyClub(String joinclub);
	
}
