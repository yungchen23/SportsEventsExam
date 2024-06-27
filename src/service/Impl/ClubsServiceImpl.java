package service.Impl;

import java.util.List;

import dao.Impl.ClubsDaoImpl;
import model.Clubs;
import model.Member;
import service.ClubsService;

public class ClubsServiceImpl implements ClubsService {
	public static void main(String[] args) {

		ClubsServiceImpl csi = new ClubsServiceImpl();

//		Clubs c= new Clubs(null,"無敵艦隊",null,null,null,null,null,null);
//		csi.addClubs(c);
//		
//		List<Clubs>l = csi.getAllClubs();
//		for(Clubs x :l ) {
//			System.out.println(x.getClubId() + "==" + x.getClubName());
//			
//		}
//		System.out.println("===================================");
//		Clubs cc = csi.getClubsById(2);
//			System.out.println(cc.getClubId() + "==" + cc.getClubName());

		Clubs c = csi.getClubsByName("天龍國");
//		System.out.println(c);
//		System.out.println(c.getClubId());

//		Clubs c=new ClubsServiceImpl().getClubsByClubId("c00001");
//		c.setClubUrl("www.facebook.com");
//		c.setClubBillboard("天真活潑善良可愛又美麗");
//		
//		new ClubsServiceImpl().updateClubs(c);

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
//			Member[] member = list.toArray(new Member[list.size()]);
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
		
//		System.out.println("list.size()=" + list.size());
//		System.out.println("list.isEmpty()=" + list.isEmpty());
//		System.out.println("-----------------------------");
		
		if (!list.isEmpty()) {   //檢查列表是不是空
			
//			Clubs[] club2 = list.toArray(new Clubs[list.size()]);  

			for (Clubs x : list) {
//				System.out.println("x.getClubName()=" + x.getClubName());
//				System.out.println("clubName=" + clubName);
//				System.out.println(x.getClubName().equals(clubName));
//				System.out.println("-------------------");
				if (x.getClubName().equals(clubName)) {

					club = new ClubsServiceImpl().getClubsById(x.getId());
//					System.out.println("@=>"+club);
					return club;
				}
			}
		}
//		System.out.println("@@=>"+club);
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
