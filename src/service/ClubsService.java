package service;

import java.util.List;

import model.Clubs;

public interface ClubsService {


	// C
	void addClubs(Clubs c);

	// R
	List<Clubs> getAllClubs();
	Clubs getClubsById(int id);
	Clubs getClubsByClubId(String ClubId);
	Clubs getClubsByName(String clubName);
	

	
	//U
	void updateClubs(int id,Clubs club);	//編輯社團
	void updateClubs(Clubs club);			//編輯社團
	void updateClubsName(int id,Clubs c); //修改社團名字
		
	//D
	void deletedClubs(int id);  //解散社團
	
	
	
}
