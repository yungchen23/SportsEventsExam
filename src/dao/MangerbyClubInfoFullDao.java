package dao;

import java.util.List;

import model.views.mangerbyclubinfoFull;

public interface MangerbyClubInfoFullDao {

	List<mangerbyclubinfoFull> getAllMember();
	List<mangerbyclubinfoFull> getMemberbyClub(String joinclub);
	
}
