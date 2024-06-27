package service.Impl;

import java.util.List;

import model.views.mangerbyclubinfo;
import dao.Impl.MangerbyClubInfoDaoImpl;
import service.MangerbyClubInfoService;

public class MangerbyClubInfoServiceImpl implements MangerbyClubInfoService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static MangerbyClubInfoDaoImpl mcdi = new MangerbyClubInfoDaoImpl();
	
	@Override
	public List<mangerbyclubinfo> getAllMember() {
		return mcdi.getAllMember();
	}

	@Override
	public List<mangerbyclubinfo> getMemberbyClub(String clubId) {
	
		return mcdi.getMemberbyClub(clubId);
	}

}
