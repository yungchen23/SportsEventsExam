package service.Impl;

import java.util.List;

import dao.Impl.ClubsDaoImpl;
import model.Clubs;
import model.Member;
import service.ClubsService;

public class ClubsServiceImpl implements ClubsService {

	public static void main(String[] args) {
		
	}
	
	private static ClubsDaoImpl cdi = new ClubsDaoImpl();

	@Override
	public void addClubs(Clubs c) {

		cdi.addClubs(c);
	}

	@Override
	public List<Clubs> getAllClubs() {

		return cdi.getAllClubs();
	}

	@Override
	public Clubs getClubsById(int id) {
		List<Clubs> list = cdi.getClubsById(id);

		if (list.size() != 0) {
			Clubs[] club = list.toArray(new Clubs[list.size()]);
			return club[0];
		} else {
			return null;
		}
	}

	@Override
	public Clubs getClubsByName(String clubName) {
		Clubs club = null;
		List<Clubs> list = cdi.getAllClubs();

		if (!list.isEmpty()) { // 檢查列表是不是空

			for (Clubs x : list) {
				if (x.getClubName().equals(clubName)) {

					club = new ClubsServiceImpl().getClubsById(x.getId());
					return club;
				}
			}
		}
		return club;
	}

	@Override
	public Clubs getClubsByClubId(String ClubId) {
		List<Clubs> list = cdi.getClubsByClubId(ClubId);
		if (list.size() != 0) {
			Clubs[] c = list.toArray(new Clubs[list.size()]);
			return c[0];
		} else {
			return null;
		}
	}

	@Override
	public void updateClubs(int id, Clubs club) {

		Clubs c = new ClubsServiceImpl().getClubsById(id);

		c.setClubIntroduction(club.getClubIntroduction());
		c.setClubUrl(club.getClubUrl());
		c.setUpdateDate(club.getUpdateDate());

		cdi.updateClubs(c);
	}

	@Override
	public void updateClubs(Clubs club) {
		Clubs c = new ClubsServiceImpl().getClubsByClubId(club.getClubId());
		c.setClubUrl(club.getClubUrl());
		c.setClubBillboard(club.getClubBillboard());
		c.setUpdateDate(club.getUpdateDate());
		cdi.updateClubs(c);

	}

	@Override
	public void updateClubsName(int id, Clubs club) {

		Clubs c = new ClubsServiceImpl().getClubsById(id);

		c.setClubName(club.getClubName());
		c.setUpdateDate(club.getUpdateDate());

		cdi.updateClubsName(c);

	}

	@Override
	public void deletedClubs(int id) {
		cdi.deletedClubs(id);
	}

}
