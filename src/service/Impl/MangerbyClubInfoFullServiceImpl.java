package service.Impl;

import java.util.List;

import model.views.mangerbyclubinfoFull;
import dao.Impl.MangerbyClubInfoFullDaoImpl;
import service.MangerbyClubInfoFullService;

public class MangerbyClubInfoFullServiceImpl implements MangerbyClubInfoFullService{

	public static void main(String[] args) {
		

	}

	private static MangerbyClubInfoFullDaoImpl mbcf = new MangerbyClubInfoFullDaoImpl();
	
	@Override
	public List<mangerbyclubinfoFull> getAllMember() {
		
		return mbcf.getAllMember();
	}

	@Override
	public List<mangerbyclubinfoFull> getMemberbyClub(String joinclub) {
		
		return mbcf.getMemberbyClub(joinclub);
	}

}
